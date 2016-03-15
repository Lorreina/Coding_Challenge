import csv
import copy
import math
from collections import defaultdict

# var is the dictionary to store variables
var = defaultdict(int)
# matrix is the list to store equations
matrix = list()
# the max and min value of variable
min_value = 1
max_value = 40


# read data from input csv
def read_data ():
    global var
    global matrix
    pos = 0
    with open('sample_data.csv', 'rb') as csvfile:
        datareader = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in datareader:
            tmp = [0] * (len(var) + 1)
            if pos == 0:
                pos += 1
                continue

            # add variable to equation
            for i in range(len(row) - 1):
                x = row[i].strip()
                # variable x is already in the dictionary var
                if x in var:
                    tmp[var[x]] = 1
                else: # found new variable, add it to dictionay var
                    var[x] = len(var)
                    var[x] += 1
                    tmp.append(1)
                    for equation in matrix:
                        equation.append(0)

            # add price to equation
            price = (row[len(row) - 1].strip())[1:]
            tmp[0]= float(price)
            matrix.append(tmp)

# eliminate variables in the matrix
def elimination():
    global matrix
    global var

    free_var = 0
    for i in range(len(matrix), len(var)):
        matrix.append([0] * (len(var) + 1))

    for i in range(len(var)):
        # check if the (i + 1)th item of row i is non-zero
        if (matrix[i - free_var][i + 1] == 0):
            free_var_new = 1
            # switch row
            for j in range(i + 1 - free_var, len(matrix)):
                if(matrix[j][i + 1] != 0):
                    free_var_new = 0
                    tmp = copy.deepcopy(matrix[j])
                    matrix[j] = copy.deepcopy(matrix[i - free_var])
                    matrix[i - free_var] = copy.deepcopy(tmp)
                    break;
            free_var += free_var_new
            if (j == (len(matrix) - 1)):
                 continue;

        for j in range(i + 1, len(matrix)):
            matrix[j] = minus(matrix[i], matrix[j], i + 1)

    # check if there's valid root
    if (len(var) < len(matrix)):
        for i in range(len(matrix) - 1, len(var) - 1, -1):
            if (matrix[i][0] != 0):
                return 0
            matrix.remove(matrix[i])


    return 1

def re_elimination():
    global matrix

    for i in range(len(matrix) - 2, -1, -1):
        for j in range(i + 1, len(matrix)):
            matrix[i] = minus(matrix[j], matrix[i], i + 2)


def minus(array1, array2, index):
    if (array1[index] == 0):
        return array2
    times = array2[index] / array1[index]
    for i in range(len(array1)):
        array2[i] = array2[i] - times * array1[i]

    return array2

def order():
    global matrix

    matrix_copy = list()
    free_var = 0

    for i in range(len(matrix)):
        if (matrix[i - free_var][i + 1] == 0):
            matrix_copy.append([0] * (len(var) + 1))
            free_var += 1
        else:
            matrix_copy.append(matrix[i - free_var])

    for i in range(0, free_var):
        if (matrix[len(var) - i - 1][0] != 0):
            return 0
    matrix = matrix_copy
    return 1

def getroot():
    global matrix
    # global root
    global var

    root = list()
    root = updateroot(len(var), root)
    # print root
    return root


def updateroot(line, root):
    global matrix
    global min_value
    global max_value

    root_update = list()


    if (line == 0):
        root_update.append(root)
        return root_update

    if (matrix[line - 1][line] == 0): # find free variable

        # find local min and max value for optimization
        local_min_value = min_value
        local_max_value = max_value
        for i in range(line - 1):
            if (matrix[i][line] != 0):
                isPos = True
                isNeg = True
                sum = 0
                for j in range(1, line):
                    sum += matrix[i][j]
                    if matrix[i][j] < 0:
                        isPos = False
                    elif (matrix[i][j] > 0):
                        isNeg = False
                boundary = (matrix[i][0] - sum) / matrix[i][line]
                if (isPos == True):
                    local_max_value = min(max_value, int(math.floor(boundary)))
                elif (isNeg == False):
                    local_min_value = max(min_value, int(math.ceil(boundary)))
        x = 1
        for i in range(line - 1):
            matrix[i][0] -= (local_min_value - min_value) * matrix[i][line]
        for x in range(local_min_value, local_max_value + 1):
            root_copy = setroot(line - 1, x, root)
            for i in range(line - 1):
                matrix[i][0] -= matrix[i][line]
            root_update += updateroot(line - 1, root_copy)

        for i in range(line - 1):
            matrix[i][0] += local_max_value * matrix[i][line]

    else:
        root_copy = setroot(line - 1, matrix[line - 1][0] / matrix[line - 1][line], root)
        if (len(root_copy) == 0):
            return root_copy
        root_update = updateroot(line - 1, root_copy)

    return root_update

def setroot(index, value, root_list):
    global var

    root = copy.deepcopy(root_list)
    if (value < 1) or (value > 40):
        return list()
    if (value - round(value)) != 0:
        return list()
    else:
        value = int(value)

    if (len(root) == 0):
        root = [0] * len(var)

    root[index] = value;

    return root

def write_root(root):
    global var
    for i in range(len(root)):
        file_name = './root/root' + str(i + 1) + '.csv'
        with open(file_name, 'wb') as csvfile:
            datawriter = csv.writer(csvfile, delimiter = ',', quotechar = '|')
            datawriter.writerow(['Ingredient', 'Price'])
            for j in range(len(var)):
                datawriter.writerow([var.keys()[j]] + [root[i][j]])
    print "There's ", len(root), " solution(s)!"


def main():

    read_data()
    if (elimination()):
        re_elimination()
        if (order()):
            print "order complete!"
            write_root(getroot())
        else:
            print "There's no root for this equation!"
    else:
        print "There's no root for this equation!"

    # print matrix

if __name__ == '__main__':
    main()


