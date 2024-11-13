
# Relational Data Model

## Entities and Relationships
Based on your system description, the key entities are:

- Client
- Instructor
- Offering
- Location
- TimeSlot
- Booking
- Administrator

## Relational Tables

### Table: Client

| Column       | Type     | Constraints                                  |
|--------------|----------|----------------------------------------------|
| client_id    | INTEGER  | PRIMARY KEY                                  |
| name         | TEXT     | NOT NULL                                     |
| phone_number | TEXT     | NOT NULL                                     |
| age          | DATE     | NOT NULL                                     |
| guardian_id  | INTEGER  | FOREIGN KEY REFERENCES Client(client_id)     |

### Table: Instructor

| Column         | Type          | Constraints         |
|----------------|---------------|---------------------|
| instructor_id  | INTEGER       | PRIMARY KEY         |
| name           | TEXT          | NOT NULL            |
| availabilities | ARRAY(String) | NOT NULL            |
| specialization | TEXT          | NOT NULL            |

### Table: Location

| Column         | Type     | Constraints      |
|----------------|----------|------------------|
| location_id    | INTEGER  | PRIMARY KEY      |
| name           | TEXT     | NOT NULL         |
| city           | TEXT     | NOT NULL         |
| address        | TEXT     | NOT NULL         |

### Table: TimeSlot

| Column      | Type     | Constraints      |
|-------------|----------|------------------|
| timeslot_id | INTEGER  | PRIMARY KEY      |
| day_of_week | TEXT     | NOT NULL         |
| start_time  | TIME     | NOT NULL         |
| end_time    | TIME     | NOT NULL         |
| start_date  | DATE     | NOT NULL         |
| end_date    | DATE     | NOT NULL         |

### Table: Offering

| Column         | Type     | Constraints                                   |
|----------------|----------|-----------------------------------------------|
| offering_id    | INTEGER  | PRIMARY KEY                                   |
| lesson_type    | TEXT     | NOT NULL                                      |
| mode           | TEXT     | CHECK (mode IN ('group', 'private'))          |
| is_available   | BOOLEAN  | NOT NULL                                      |
| date           | DATE     | NOT NULL                                      |
| instructor_id  | INTEGER  | FOREIGN KEY REFERENCES Instructor(instructor_id) |
| location_id    | INTEGER  | FOREIGN KEY REFERENCES Location(location_id)     |
| timeslot_id    | INTEGER  | FOREIGN KEY REFERENCES TimeSlot(timeslot_id)     |

**Unique Constraint:** (date, timeslot_id, location_id) to ensure offerings are unique per date, time slot, and location.

### Table: Booking

| Column         | Type     | Constraints                                 |
|----------------|----------|---------------------------------------------|
| booking_id     | INTEGER  | PRIMARY KEY                                 |
| booking_date   | DATE     | NOT NULL                                    |
| client_id      | INTEGER  | FOREIGN KEY REFERENCES Client(client_id)    |
| offering_id    | INTEGER  | FOREIGN KEY REFERENCES Offering(offering_id)|

**Unique Constraint:** (client_id, offering_id) to prevent duplicate bookings.

### Table: Administrator

| Column         | Type     | Constraints     |
|----------------|----------|-----------------|
| admin_id       | INTEGER  | PRIMARY KEY     |
| username       | TEXT     | NOT NULL        |
| password       | TEXT     | NOT NULL        |
