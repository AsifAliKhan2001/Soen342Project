# System Operations and Contracts

| **System Operations**                                         | **Contracts**                                |
|---------------------------------------------------------------|----------------------------------------------|
| `createOffering(lessonType, schedule, location, mode, space)` |                                              |
| `viewAvailableOfferings(instructor)`                          |                                              |
| `selectOffering(instructor, offeringID)`                      |                                              |
| `viewPublicOfferings()`                                       |                                              |

---

## System Operation: createOffering Contract

**CO1**: `createOffering()`

- **Operation**: `createOffering(lessonType: LessonType, schedule: Schedule, location: Location, mode: Mode, space: Space)`
- **Cross References**: Use Case: Process Offerings

**Preconditions**:
- The administrator is authenticated and has the necessary permissions to create offerings.
- The `lessonType` includes a valid lesson type (e.g., swimming, judo) recognized by the system.
- The schedule is valid and does not conflict with existing offerings at the same location and time slots.
- The location exists within the organization’s list of locations.
- The mode is either 'private' or 'group'.

**Postconditions**:
- A new offering is created with the specified `lessonType`, schedule, location, and mode.
- The offering is added to the organization’s list of offerings.
- The `offeringAvailable` attribute is set to true, making it visible to instructors for selection.
- The offering is not yet visible to the public (clients).

---

## System Operation: viewAvailableOfferings Contract

**CO2**: `viewAvailableOfferings()`

- **Operation**: `viewAvailableOfferings(instructor: Instructor)`
- **Cross References**: Use Case: Process Offerings

**Preconditions**:
- The instructor is authenticated and has a registered account in the system.
- The instructor has specified their specializations and availability (cities).

**Postconditions**:
- The system retrieves all offerings where:
    - The `offeringAvailable` attribute is true.
    - The `offeringLessonType` matches one of the instructor’s specializations.
    - The `offeringLocation` is within the instructor’s availability.
- A list of matching offerings is displayed to the instructor with relevant details (e.g., lesson type, schedule, location, mode).

---

## System Operation: selectOffering Contract

**CO3**: `selectOffering()`

- **Operation**: `selectOffering(instructor: Instructor, offeringID: String)`
- **Cross References**: Use Case: Process Offerings

**Preconditions**:
- The instructor is authenticated.
- The `offeringID` corresponds to an existing offering in the system.
- The `offeringAvailable` attribute is true.
- The `offeringLessonType` matches one of the instructor’s specializations.

**Postconditions**:
- The `offeringAvailable` attribute is set to false, indicating it has been taken by an instructor.
- The `offeringInstructor` attribute is set to the current instructor.
- The offering is now visible to the public (clients) for booking purposes.
- The offering is removed from the list of available offerings for other instructors.
- A confirmation is provided to the instructor indicating successful assignment.

---

## System Operation: viewPublicOfferings Contract

**CO4**: `viewPublicOfferings()`

- **Operation**: `viewPublicOfferings()`
- **Cross References**: Use Case: Process Offerings

**Preconditions**:
- Offerings have been created and assigned to instructors.
- The `offeringAvailable` attribute is false for these offerings (since they’ve been taken by instructors).

**Postconditions**:
- The system displays a list of offerings that are available to clients for booking.
- Each offering includes details such as lesson type, schedule, location, mode, and assigned instructor.