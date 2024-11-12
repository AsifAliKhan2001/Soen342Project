
# System Operations and Operation Contracts

## Identified System Operations

From the SSD (System Sequence Diagram), the following system operations are identified:

- **login(username, password)**
- **viewOfferings()**
- **selectOffering(offeringID)**
- **bookingSuccess(bookingID)**
- **cancelBooking(bookingID)** (from alternative flows)
- **viewClientBookings()**

Each operation contract details preconditions and postconditions, focusing on:

- **Instance creation and deletion**
- **Attribute modifications**
- **Associations formed or broken**

## Operation Contracts

### 1. **Operation: login**

- **Operation**: `login(username: String, password: String)`

#### Preconditions:
- **[P1]** A Client with the given username exists in the system.

#### Postconditions:
- **If authentication is successful**:
  - **[Post1]** A new Session instance `s` is created.
    - **Instance Creation**: `s` is an instance of Session.
    - **[Post1.2]** `s.client` is set to the authenticated Client `c`.
    - **Association Formed**: Session is linked with Client.
- **If authentication fails**:
  - **[Post2]** No changes are made to the system.

---

### 2. **Operation: viewOfferings**

- **Operation**: `viewOfferings()`

#### Preconditions:
- **[P1]** The client is authenticated and has an active Session.

#### Postconditions:
- **[Post1]** The system retrieves all available Offerings (where `offering.isAvailable = true`).
  - **Read-only operation**: No changes to the system state.

---

### 3. **Operation: selectOffering**

- **Operation**: `selectOffering(offeringID: String)`

#### Preconditions:
- **[P1]** The client is authenticated and has an active Session.
- **[P2]** An Offering with ID `offeringID` exists.
- **[P3]** The Offering is available (`o.isAvailable = true`).

#### Postconditions:
- **[Post1]** The system displays the details of the selected Offering.
  - **Read-only operation**: No changes to the system state.

---

### 4. **Operation: bookingSuccess**

- **Operation**: `bookingSuccess(bookingID: String)`

#### Preconditions:
- **[P1]** The client is authenticated and has an active Session.
- **[P2]** A Booking with ID `bookingID` exists.
- **[P3]** The Booking is available (`o.isAvailable = true`).

#### Postconditions:
- **[Post1]** A new Booking `b` is created.
  - **Instance Creation**: `b` is an instance of Booking.
- **[Post2]** `b.client` is set to the authenticated Client `c`.
  - **Association Formed**: Booking associated with Client.
- **[Post3]** `b.offering` is set to the Offering `o`.
  - **Association Formed**: Booking associated with Offering.
- **[Post4]** The Offering's availability (`o.isAvailable`) is set to false.
- **[Post5]** If `c` is under 18:
  - **[Post5.1]** `b.guardian` is set to `c.guardian`.
  - **Association Formed**: Booking associated with Guardian.

---

### 5. **Operation: cancelBooking**

- **Operation**: `cancelBooking(bookingID: String)`

#### Preconditions:
- **[P1]** The client is authenticated and has an active Session.
- **[P2]** A Booking with ID `bookingID` exists.
- **[P3]** The Booking is associated with the client or the client's guardian if the client is under 18.

#### Postconditions:
- **[Post1]** The Booking `b` is deleted.
  - **Instance Deletion**: `b` is removed from the system.
- **[Post2]** The associated Offering's availability (`o.isAvailable`) is set to true.
  - **Attribute Modification**: Availability status updated.
- **[Post3]** All associations of `b` are removed:
  - **Disassociated from Client `c`**
  - **Disassociated from Offering `o`**
  - **Disassociated from Guardian `g` if applicable**

---

### 6. **Operation: viewClientBookings**

- **Operation**: `viewClientBookings()`

#### Preconditions:
- **[P1]** The client is authenticated and has an active Session.

#### Postconditions:
- **[Post1]** The system retrieves all bookings related to the client:
  - **[Post1.1]** Bookings directly linked to the client.
  - **[Post1.2]** If the client is under 18, also include bookings associated with the client’s guardian.
  - **Read-only operation**: No changes to the system state.

