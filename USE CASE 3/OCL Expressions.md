
# OCL Expressions

## Constraint 1: Offerings Uniqueness
**Description:** Offerings are unique. Multiple offerings on the same day and time slot must be offered at different locations.

**OCL Expression:**

```ocl
context Offering
inv UniqueOfferings:
    Offering.allInstances()->forAll(o1, o2 |
        o1 <> o2 and o1.date = o2.date and o1.timeSlot = o2.timeSlot
        implies o1.location <> o2.location)

```
---

## Constraint 2: Underage Clients Must Have Guardians
**Description:** Any client who is underage must necessarily be accompanied by an adult who acts as their guardian.

**OCL Expression:**

```ocl
context Client
inv UnderageClientMustHaveGuardian:
    self.age < 18 implies self.guardian <> null
```

**Explanation:** If a client's age is less than 18, they must have a non-null guardian.

---

## Constraint 3: Offering's City Must Be in Instructor's Availabilities
**Description:** The city associated with an offering must be one of the cities that the instructor has indicated in their availabilities.

**OCL Expression:**

```ocl
context Offering
inv InstructorAvailability:
    self.instructor.availabilities->includes(self.location.city)
```
**Explanation:** Ensures that the city of the `Offering`'s `Location` is included in the `Instructor`'s availabilities.

---

## Constraint 4: No Multiple Bookings on Same Day and Time Slot
**Description:** A client does not have multiple bookings on the same day and time slot.

**OCL Expression:**

```ocl
context Client
inv NoMultipleBookingsSameDayTimeSlot:
    self.bookings->forAll(b1, b2 |
        b1 <> b2 implies
        (b1.offering.date <> b2.offering.date or b1.offering.timeSlot <> b2.offering.timeSlot)
    )
```
**Explanation:** For each `Client`, their bookings must be unique based on the `date` and `timeSlot` of the associated `Offering`.
