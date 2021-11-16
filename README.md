 #Simple Auction Assignment
 
 ##Step1: Created SpringBoot project based on the requirements provided from https://start.spring.io/
 
 ##Step2: Added dependencies to the project springWeb, H2Database, SpringJPA
 
 ##Step3: imported project into eclipse workspace
 
 ##Step4: created Model object Auction.java and IdentifiableMarks.java under model packages
 
 ### I have provided Hibernate OneToMany and ManyToOne relation in the POJO objects (Auction.java and IdentifiableMarks.java)
 
 ##Step 4: Created the AuctionRepository using JPA(JpaRepository) 
 
 ##Step5: Created Auction controller with the REST API annotations which can support All HTTP requests (GET/ GET by ID/ POST/ PUT/ DELETE by ID)
 
 ##Step6: Updated the Application.properties with the H2 datasource information
 
 ##Step7: RUN and TEST: mvn spring-boot:run  (run the following command and it will create the tables in H2 data base using JQL queries will be published in the console)
 
 ##Step8: Login to the H2 db using http://localhost:8080/h2-data check if the tables are created or not 
 
 ##Step9: Use POSTMAN or any rest client to make the call 
 
 ##Step10: Select POST request from the postman: http://localhost:8080/api/unicorns    
 
 {
	
  "name": "Sparkle Princess",
  "hairColor": "White",
  "hornLength": 104,
  "hornColor": "Gold",
  "eyeColor":  "Sapphire",
  "height": 94,
  "heightUnit": "cm",
  "weight": 104,
  "weightUnit": "kg",
  "identifiableMarks": [
      {
        "side": "Left",
        "location": "Hind Quarters",
        "mark": "Star",
        "color": "Blue"
      }
    ]
}
 
 ### on response you should be seeing request fullfilled
 
 ##Step11: Now select GET option in POSTMAN:  http://localhost:8080/api/unicorns
 
 
 
 
 
 
 
 