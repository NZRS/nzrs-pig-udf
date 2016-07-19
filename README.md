# Pig UDF collection

The following are a few functions created for Pig used by NZRS to
analyze data

## Simmilarity

Set of string simmilarity functions using the
[SimMetrics](https://github.com/Simmetrics/simmetrics) library.

Currently implemented

* JaroWrinkler
* Levenshtein
* LevenshteinDamerau

## UPPER

Test function to convert a string to uppercase

## HashCode

Function to generate a hash number from a string, used to create a
partitioned dataset.
