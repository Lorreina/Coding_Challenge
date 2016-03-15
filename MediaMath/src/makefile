all:    
	chmod a+rwx `pwd`

clean:
	rm -rf root
	mkdir root

command_line:
	make clean
	python Price_Calculate_cmd.py

file:
	make clean
	python Price_Calculate_file.py

continue:
	make clean
	python Price_Update.py
