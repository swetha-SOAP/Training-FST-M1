# Import pandas
import pandas
 
# Read data from Excel sheet
dataframe = pandas.read_excel('sample.xlsx')
 
# Print the dataframe
print(dataframe)
 
# Print the number of rows and columns
print("====================================")
print("Number of rows and columns:", dataframe.shape)
 
# Print the data in the emails column only
print("====================================")
print("Emails:")
print(dataframe['Email'])
 
# Sort the data based on FirstName in ascending order and print the data
print("====================================")
print("Sorted data:")
print(dataframe.sort_values('FirstName'))
COPY
PYTHON
HANDLING XML FILES
HANDLING XML FILES
First, let's create a sample xml file we can use.

Create an excel file using the data provided and save it as properties.xml.

We will be using this file as an example to read and write data to.

<?xml version="1.0" encoding="UTF-8"?>
<root>
	<bathrooms>
		<n35237 type="number">1.0</n35237>
		<n32238 type="number">3.0</n32238>
		<n44699 type="number">nan</n44699>
	</bathrooms>
	<price>
		<n35237 type="number">7020000.0</n35237>
		<n32238 type="number">10000000.0</n32238>
		<n44699 type="number">4128000.0</n44699>
	</price>
	<property_id>
		<n35237 type="number">35237.0</n35237>
		<n32238 type="number">32238.0</n32238>
		<n44699 type="number">44699.0</n44699>
	</property_id>
</root>
PYTHON
READING JSON FILES
51 . 2


