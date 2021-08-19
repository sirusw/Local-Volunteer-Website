# Local-Volunteer-Website
This website intends to solve the problems of inefficient posting and registration of volunteer activities based on my own experiences during the 2021 Henan Flood 
happened in my city of Zhengzhou in China.

# Background
On July 20, 2021. Zhengzhou, as a megacity with 12 million people, experienced the heaviest rainfall ever recorded with 201.9 mm within a single hour, and a cumulative precipitation of 617.1 mm within a 3-day period, which is close to Zhengzhou's average annual precipitation of 640.8 mm. With such a heavy rainfall, the city of Zhengzhou gets flooded quickly, with supply outage and traffic shutdown. 

<img src="https://user-images.githubusercontent.com/50982809/130142164-ecbc76a0-e334-479c-80f7-9460e7f40fb2.jpg" width="510" height="382">
Taken in my neighborhood
<br /><br />

Citizens and local volunteer associations quickly started to create WeChat groups for posting and registrating for volunteer activities. But with various founders of the group, whether by the government, local volunteer associations, or normal citizens, there are too many groups, with too many repeated posting in different groups which results in inefficiency. Therefore, this project attempts to solve this problem. 

<img src="https://user-images.githubusercontent.com/50982809/130142181-c78fa7f5-aeb7-4e5b-960e-1dc51c5e94b5.jpg" width="382" height="510">
A volunteer activity I participated
<br />

# Introduction
Users of this website are required to register and login before posting or signing up for volunteer activities, then users could perform these actions with ease by doing so directly on the map. Posted activities and registered users are stored in MySQL database. In the settings, users could see the activities they posted and participated. Users can also change personal information in settings.

# Tech
- Google Maps API: posting and registering volunteering events directly on the map. 
- SSM (Spring, SpringMVC, Mybatis) framework
- Redis: login features
- Bootstrap: front-end styling
- MySQL

# Overview
## Main page
![](https://user-images.githubusercontent.com/50982809/130137979-b3d7fe6a-8b0a-4983-9c86-56185ce68238.png)

## Sign up for volunteer activities directly on the map
![](https://user-images.githubusercontent.com/50982809/130138060-a3e5b0d1-466a-46d9-b4db-e8e69fc6972a.png)

## Post a volunteer activities directly on the map
![Just click on the map and the address will be recorded](https://user-images.githubusercontent.com/50982809/130138268-c777fad7-88d5-40bf-829c-7a74db622373.png)

## Settings - Events posted by current user
![](https://user-images.githubusercontent.com/50982809/130138310-c3b67775-7fa4-40ec-a7ba-ad9fc9cfad22.png)

## Settings - Events current user is participating
![](https://user-images.githubusercontent.com/50982809/130138418-cc72cc70-f44d-41ec-ae1b-7d97989e0fb5.png)

## Settings - Change personal information
![](https://user-images.githubusercontent.com/50982809/130138442-311709e4-2578-4021-970f-85d757d75762.png)

# Future
This project is developed within a short period of time. There are more features to be added in the future.
Also, within such short period of development time, planning and structuring were not perfect and some details had to be fixed and/or added during implementation.
In future projects, a more detailed and thorough planning should be done prior to implementation.
