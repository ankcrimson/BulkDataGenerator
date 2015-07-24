# Bulk Testdata Generator
## Initial GUI Screen:
![Initial Screen](https://raw.githubusercontent.com/ankcrimson/BulkDataGenerator/master/BulkDataGenerator/images/web/1.png)
## Terms Explained:
### Source File: 
This is an example source file to be used as a base model for replication. This can be any kind of text readable file.
### Target Directory: 
This is a directory where our generated files will be stored into
### Business Keys: 
This is the part where its mentioned which part of data to consider as business keys so that that part may be kept as unique in each and every generated file.
### Number of files: 
This is the part where we define how many files will be generated.
### Extension: 
This is additional field which is optional to use, This can be used if we want a specific date format in our generated files as an extension

## Sample Execution:
![Sample Execution Screen](https://raw.githubusercontent.com/ankcrimson/BulkDataGenerator/master/BulkDataGenerator/images/web/2.png) 
### Our Input File:

![Input file](https://raw.githubusercontent.com/ankcrimson/BulkDataGenerator/master/BulkDataGenerator/images/web/3.png)
 
### Output Files:

![Output Files Generated](https://raw.githubusercontent.com/ankcrimson/BulkDataGenerator/master/BulkDataGenerator/images/web/4.png)

### Sample Generated Output File:

![Generated Output File](https://raw.githubusercontent.com/ankcrimson/BulkDataGenerator/master/BulkDataGenerator/images/web/5.png)
Here we can see that book id got changed in each and every file.
The value of book id will change for each and every generated file starting from 102 onwards…

## Explaination of Business Keys field:
bk101::bk{101}
### format: 
[source search value][::][what to replace with {a numeric value to be incremented in each file}]

Now here is where all the magic happens… The numeric value gets incremented for each and every file that gets generated.
Since this just replaces the file contents, it becomes platform and format independent and hence whichever file that could be opened by a text editor, can be replicated with the help of this tool.

## What if my file contains multiple business keys to be edited in each file?
Solution is to use multiple business keys separated by double semicolons… eg.

![Complex Execution](https://raw.githubusercontent.com/ankcrimson/BulkDataGenerator/master/BulkDataGenerator/images/web/6.png)

## Sample Output File:
### File1: 
![Sample Generated File](https://raw.githubusercontent.com/ankcrimson/BulkDataGenerator/master/BulkDataGenerator/images/web/7.png)
### File2: 
![Sample Generated File](https://raw.githubusercontent.com/ankcrimson/BulkDataGenerator/master/BulkDataGenerator/images/web/8.png)

This tool supports huge file size and can support generation of millions of files.

## For any queries contact me or any other contributors who might join in.

Author:
>Ankur Srivastava [ankcrimson]
>ankcrimson@yahoo.com
>AnkurPrakash.Srivastava@gmail.com
