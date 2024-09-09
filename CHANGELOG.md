# 0.9.0-SNAPSHOT (yyyy-MM-dd)

Features:
* ?

Improvements:
* ?

Fixes:
* ?


# 0.8.1 (2024-08-09)

Features:
* Add numeric ID to RexsValueType and RexsUnitId

Improvements:
* Improved validation of REXS files


# 0.7.0 (2024-05-06)

Features:
* feat: Adjustments for relations in the REXS database


# 0.6.1 (2024-01-24)

Features:
* REXS 1.6 added


# 0.5.1 (2023-06-22)


# 0.5.0 (2023-06-22)

Features:
* Upgraders for REXS versions 1.0 to 1.5


# 0.4.0 (2023-05-08)

Features:
* REXS 1.4 Change: Unit "°" changed to "deg"
* REXS 1.4: Component types, attribute ids, units
* REXS 1.5: Component types, attribute ids, units
* Input/output of REXS json
* Input/output of rexsz format
* Provided CLI for functions of the REXS-API

Improvements:
* Upgrade to Java 17
* Moved from http://github.com/fva-gmbh/rexs-api to http://github.com/fva-net/rexs-api-java
* Merged REXS database model files for different languages (kept the old ones for backward compatibility)
* Detached JAXB model from REXS core model


# 0.3.0 (2021-10-19)

Features:
* Added handling of Base64 encoded matrixes
* Added a validator for REXS files
* Reading of .rexsz files
* Added the 'RexsModelObjectFactory' to enable custom implementations of the 'RexsModel' classes
* Added possibility to specify custom XML attributes in REXS files (are ignored during validation)

Improvements:
* Changed group id from fva-gmbh.rexs-api to de.fva-service.rexs
* Added suffix 'Base64' to setters for Base64 encoded values
* Added get*Value() methods in RexsComponent for direct access to attribute values
* Added getValue(RexsValueType) method in RexsAttribute


# 0.2.0 (2021-07-29)

Features:
* Handling of Base64 encoded arrays
* New REXS data types: enum_array & array_of_integer_arrays
* Access to REXS XSD schema files


# 0.1.0 (2021-07-22)

First release