# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- ???

### Changed

- Changed assembly component from `involute_spline_connection` to `involute_spline_gear_shaft` for assembly relations in REXS versions 1.4, 1.5, 1.6 and 1.7

### Fixed

- Full support for binary information in arrays and matrices in the .rexsj format


## [0.13.0] - 2025-02-19

### Added

- Added `RexsVersion.getAll()`.
- Synchronized `RexsIoFormat` with permitted extensions from the REXS specification

## [0.12.0] - 2024-12-13

### Added

- Added REXS 1.7

### Fixed

- Fixed the issue that `RexsVersion.findByModelVersion(...)` did not searches for additional model versions.
- Fixed the issue that schema files contains non-UTF8 characters.

## [0.11.0] - 2024-12-05

### Changed

- JAXB classes are now using element wrappers instead of wrapper classes
- RexsVersion with distinction in schemaVersion and modelVersion
- Validation: Display unknown custom attributes as a warning

## [0.10.0] - 2024-11-05

### Added

- Added numericId to components in schema files

### Changed

- Using JAXB to generate data classes
- Renaming default branch from "master" to "main"
- Changed class types on data classes from `BigInteger` and `BigDecimal` to `int` and `double`

### Removed

- Dropped language-dependent schema files

### Fixed

- Relations not loaded in schema for versions lower than 1.6

## [0.9.0] - 2024-10-23

### Added

- Automatic publishing to Maven Central for releases
- Adding missing "applicationLanguage" to XML and XSD
- Add "DEV" as a constant version

### Changed

- Renaming "DbModel" to "Schema" (packages, classes)

## [0.8.1] - 2024-08-09

### Added

- Add numeric ID to RexsValueType and RexsUnitId

### Changed

- Improved validation of REXS files

## [0.7.0] - 2024-05-06

### Added

- Adjustments for relations in the REXS database

## [0.6.1] - 2024-01-24

### Added

- REXS 1.6 added

## [0.5.1] - 2023-06-22

## [0.5.0] - 2023-06-22

### Added

- Upgraders for REXS versions 1.0 to 1.5

## [0.4.0] - 2023-05-08

### Added

- REXS 1.4 Change: Unit "°" changed to "deg"
- REXS 1.4: Component types, attribute ids, units
- REXS 1.5: Component types, attribute ids, units
- Input/output of REXS json
- Input/output of rexsz format
- Provided CLI for functions of the REXS-API

### Changed

- Upgrade to Java 17
- Moved from http://github.com/fva-gmbh/rexs-api to http://github.com/fva-net/rexs-api-java
- Merged REXS database model files for different languages (kept the old ones for backward compatibility)
- Detached JAXB model from REXS core model

## [0.3.0] - 2021-10-19

### Added

- Added handling of Base64 encoded matrixes
- Added a validator for REXS files
- Reading of .rexsz files
- Added the 'RexsModelObjectFactory' to enable custom implementations of the 'RexsModel' classes
- Added possibility to specify custom XML attributes in REXS files (are ignored during validation)

### Changed

- Changed group id from fva-gmbh.rexs-api to de.fva-service.rexs
- Added suffix 'Base64' to setters for Base64 encoded values
- Added get*Value() methods in RexsComponent for direct access to attribute values
- Added getValue(RexsValueType) method in RexsAttribute

## [0.2.0] - 2021-07-29

### Added

- Handling of Base64 encoded arrays
- New REXS data types: enum_array & array_of_integer_arrays
- Access to REXS XSD schema files

## [0.1.0] - 2021-07-22

### Added

- First release
