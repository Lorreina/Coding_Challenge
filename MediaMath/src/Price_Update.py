from collections import defaultdict
import math
import copy
import csv
import os

# var is the dictionary to store variables
var = defaultdict(int)
# matrix is the list to store equations
matrix = list()
# set the max and min value for variable
max_value = 40
min_value = 1
tmp = list()
root = list()



def main():
    global root



    while True:
    # for index in range(3):
        var_count = len(var)
        has_old_var = read_data()
        delete_output()
        if (elimination(has_old_var, var_count)):
            if (has_old_var):
                re_elimination()
                # build map for tmp
                map = list()
                for i in range(var_count):
                    if (tmp[i + 1] != 0):
                        map.append(i)
                if (len(tmp) == var_count + 1): # no new variables
                    # traverse the previous root
                    remove_list = list()
                    for x in range(len(root)):
                        sum = 0
                        for i in map:
                            sum += root[x][i] * tmp[i + 1]
                        if (sum != tmp[0]):
                            remove_list.append(x)
                    remove_list.reverse()
                    for x in remove_list:
                        # root.remove(root[x])
                        del root[x]

                else: # new variables
                    # build the map to store root list for new variables
                    root_new = list()
                    result_map = defaultdict(int)
                    for x in root:
                        sum = 0
                        for i in map:
                            sum += x[i] * tmp[i + 1]
                        target = tmp[0] - sum
                        if (target) in result_map:
                            root_new += merge_root([x], result_map[target])
                        else:
                            new_tmp = copy.deepcopy(tmp)
                            new_tmp[0] = target
                            result_map[target] = calculate_root_new(new_tmp, var_count + 1, len(tmp) - 1, list())
                            root_new += merge_root([x], result_map[target])
                    root = root_new
            else:
                root_new = calculate_root_new(tmp, var_count + 1, len(tmp) - 1, list())
                if (len(root) == 0):
                    root = root_new
                else:
                    root = merge_root(root, root_new)
            if (len(root) == 0):
                print "There's no root for this eqation!"
                break

            write_root(root)
        else:
            print "There's no root for this equation!"
            break

def delete_output():
    global root

    for i in range(len(root)):
        file = './root/root' + str(i + 1) + '.csv'
        os.remove(file)

def read_data():
    global tmp
    global new_var_index

    # input_list = ['Chicken Breast, Parsley, $25', 'Chicken Breast, Parsley, $25', 'Parsley, Apple, $20']
    name = raw_input("Please input the bill:")
    # name = input_list[index]
    row = name.split(',')

    has_old_var = False

    # add variable to equation
    tmp = [0] * (len(var) + 1)
    for i in range(len(row) - 1):
        x = row[i].strip()
        # variable x is already in the dictionary var
        if x in var:
            has_old_var = True
            tmp[var[x]] = 1

        else: # found new variable, add it to dictionay var
            # new_var += 1
            var[x] = len(var) + 1
            tmp.append(1)
            for equation in matrix:
                equation.append(0)
    # add price to equation
    price = (row[len(row) - 1].strip())[1:]
    tmp[0]= float(price)
    matrix.append(tmp)

    return has_old_var

# eliminate variables in the matrix
def elimination(has_old_var, var_count):
    global matrix
    global var

    for i in range(len(matrix), len(var)):
        matrix.append([0] * (len(var) + 1))

    change = -1
    if (has_old_var):
        for i in range(len(matrix) - 1):
            if (matrix[i][i + 1] == 0) and (matrix[var_count][i + 1] != 0) and (change == -1):
                change = i
            matrix[var_count] = minus(matrix[i], matrix[var_count], i + 1)

        if (change >= 0):
            matrix[change] = copy.deepcopy(matrix[var_count])
            matrix[var_count] = [0] * (len(var) + 1)

        # check if there's valid root
        if (len(var) < len(matrix)):
            for i in range(len(matrix) - 1, len(var) - 1, -1):
                if (matrix[i][0] != 0):
                    return 0
                matrix.remove(matrix[i])

    return 1





def re_elimination():
    global matrix

    for i in range(0, len(matrix) - 1):
        for j in range(i + 1, len(matrix)):
            matrix[i] = minus(matrix[j], matrix[i], j + 1)

def order(var_count):

    # find the location to insert
    for i in range (1, var_count + 1):
        if matrix[var_count][i] != 0:
            matrix[i - 1] = copy.deepcopy(matrix[var_count])
            matrix[var_count] = [0] * (var_count + 1)
            break


def minus(array1, array2, index):
    if (array1[index] == 0):
        return array2
    times = array2[index] / array1[index]
    for i in range(len(array1)):
        array2[i] = array2[i] - times * array1[i]

    return array2


def calculate_root_new(equation, start, end, root):
    global max_value
    global min_value

    root_new = list()

    if (end == start):
        root_copy = setroot(end - start + 1, equation[0], root, end - start + 1)
        root_new.append(root_copy)
        return root_new

    sum = 0
    for i in range(start, end):
        sum += equation[i]

    local_max_value = min(max_value, int(math.floor((equation[0] - sum) / equation[end])))
    local_min_value = max(min_value, int(math.ceil((equation[0] - 40 * sum) / equation[end])))

    equation[0] -= (local_min_value - min_value) * equation[end]
    for x in range(local_min_value, local_max_value + 1):
        root_copy = setroot(end - start + 1, x, root, end - start + 1)
        equation[0] -= equation[end]
        root_new += calculate_root_new(equation, start, end - 1, root_copy)
    equation[0] += local_max_value * equation[end]

    return root_new


def setroot(index, value, root_list, length):
    global var

    root = copy.deepcopy(root_list)
    if (value < 1) or (value > 40):
        return list()
    if (value - round(value)) != 0:
        return list()
    else:
        value = int(value)

    if (len(root) == 0):
        root = [0] * length

    root[index - 1] = value;

    return root



def merge_root(root_old, root_new):
    root_merge = list()
    if (len(root_new[0]) == 0):
        return root_merge
    for i in root_old:
        for j in root_new:
            root_merge.append(i + j)
    return root_merge


def write_root(root):
    global var
    for i in range(len(root)):
        file_name = './root/root' + str(i + 1) + '.csv'
        with open(file_name, 'wb') as csvfile:
            datawriter = csv.writer(csvfile, delimiter = ',', quotechar = '|')
            datawriter.writerow(['Ingredient', 'Price'])
            for j in range(len(var)):
                ingredient = var.keys()[j]
                datawriter.writerow([ingredient] + [root[i][var[ingredient] - 1]])
    print "There's ", len(root), " solution(s)!"
    # print root


if __name__ == '__main__':
    print "Welcome to the bill calculater!"
    print "Please input the bill in the fowlling formate:"
    print " Chicken Breast, Parsley, $25"
    main()
