# Description
Participant registry service is designed to keep track of a clinical trial codenamed `New Beginnings`. As a part of this 
trial, the plan is to enrol 100,000 individuals over the course of 5 years. In order to protect the personal information  
gathered as part of this trial and prevent mistakes, each individual who agrees to participate will be assigned a unique 
`reference id`.

The following information about the individual will be saved in the registry:
1. Name
2. Date of birth
3. Phone number
4. Address

This information is required to communicate with participants using different mechanisms like physical letters, SMS and 
phone calls. All communication with will include participant `reference id`.

-------------------------------------------
# Use cases:
1. As a `participant` I should be able to enrol to `New Beginnings` so that my information is available for trial.
   - Validation of `reference id` is `6-digits` after removing the `-`.
   - Validation of `phone number` to be `10-digits`.
   - Validation of `address` to have `firstline, postal code and country` information.
2. As a `customer support executive` I should be able to update participant's address/phone-number so that the participant 
   can continue to receive communication (letters/SMS/phone-calls) from `New Beginnings`.
    - Validation includes asking for participants `date of birth` while updating personal details.
    - If the `date of birth` matches along with `reference id` only then the information will be updated.
3. As a `customer support executive` I should be able to fetch the participant details when customer requires.
    - This will be done using `reference id`
    - If customer has forgotten `reference id`, the api to retrieve information using `first name` and `date-of-birth` 
      will be made available as fallback.
4. As a `customer support executive` I should be able to remove a participant from `New Beginnings` trials so that we 
   should not be communicating or tracking the participant in the system.
    - Validation includes asking for participants `date of birth` while removing personal details.
    - This means removing the participant personal details from the `personal_details` table.
    - There will be a `change log` table available in case the study needs to retrieve old participant data.
[NOTE: The `reference id` for a participant will not get updated at any given point by this service.]


-------------------------------------------
# Assumptions:
1. Every time there is new participant willing to enrol, there is a different service generating the unique 
   `reference id`. The request body will already have a `reference id` on creation of personal details call.
2. There is no authentication or authorisation.
3. There is only one instance of this service needed.


-------------------------------------------
# Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.2/gradle-plugin/reference/html/)
* [Test Containers](https://www.testcontainers.org/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-validation)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
-------------------------------------------
