🎗️ Community Donation Campaign & Donor Pledge Tracking System (Java + JDBC)
📌 Overview

The Community Donation Campaign & Donor Pledge Tracking System is a console-based Java application designed for non-profit organizations to manage donors, campaigns, pledges, and payments efficiently. 

The system separates master data (Donors & Campaigns) from transactional data (Pledges & Payments) and enforces business rules to prevent:

Invalid deletions

Over-pledging

Inconsistent payment statuses

🚀 Features

The application supports the following operations:

Register new donors

View donor details / all donors

Create donation campaigns

View campaign details / all campaigns

Record donor pledge

Record payment against pledge

List pledges by donor or campaign

Close campaign with validation

Remove donor safely

🧠 Business Logic Rules

Only ACTIVE campaigns accept pledges 

Payments update pledge status atomically

Campaign cannot close if unpaid pledges exist

Donor cannot be deleted if active pledges remain

🛠️ Technologies Used
Category	Technology
Language	Java
Database	Oracle
Connectivity	JDBC
Architecture	Layered Architecture
Interface	Console
🗄️ Database Design
Tables Used

DONOR_TBL → donor master records

CAMPAIGN_TBL → campaign details

PLEDGE_TBL → pledge transactions 


Relationships

One donor → many pledges

One campaign → many pledges

📂 Project Structure
com.donate.app
    └── DonateMain.java

com.donate.service
    └── DonateService.java

com.donate.bean
    ├── Donor.java
    ├── Campaign.java
    └── Pledge.java

com.donate.dao
    ├── DonorDAO.java
    ├── CampaignDAO.java
    └── PledgeDAO.java

com.donate.util
    ├── DBUtil.java
    ├── ValidationException.java
    ├── CampaignClosedException.java
    └── ActivePledgesExistException.java

⚙️ How to Run
1️⃣ Setup Database

Create user and schema:

CREATE USER donate_user IDENTIFIED BY donate_pwd;
GRANT CONNECT, RESOURCE TO donate_user;


Create required tables:

DONOR_TBL

CAMPAIGN_TBL

PLEDGE_TBL

2️⃣ Configure JDBC

Update database credentials inside:

DBUtil.java

3️⃣ Compile & Run
javac DonateMain.java
java DonateMain

🔐 Exception Handling

Custom exceptions used:

ValidationException → invalid input

CampaignClosedException → pledge to inactive campaign

ActivePledgesExistException → delete/close restrictions 



🧩 Architecture Layers
Layer	Responsibility
Bean	Data objects
DAO	Database operations
Service	Business logic
App	User interaction

🖥️ Sample Console Flow
1. Register Donor
2. Create Campaign
3. Record Pledge
4. Record Payment
5. View Donors
6. View Campaigns
7. Close Campaign

<img width="1073" height="318" alt="image" src="https://github.com/user-attachments/assets/c6eaa1f6-6f5b-415a-bd7a-1dd7f8f04755" />


🔮 Future Enhancements

GUI interface (JavaFX / Web)

Payment gateway integration

Report generation

Role-based login system

👩‍💻 Author

Manasha
Java | JDBC | Oracle Developer
