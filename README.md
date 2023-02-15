# TrackUserLogin
<p>This app tracks the user login also calls an external API to get geolocation.It is integrated with **Spring Security** below are the successfull screenshot of testing of the application.Where I registered two users and get their details.
</p>

![Screenshot (455)](https://user-images.githubusercontent.com/96864350/219001908-50b85193-b658-493a-923f-86c3ab0f8edb.png)



![Screenshot (456)](https://user-images.githubusercontent.com/96864350/219002030-a5e36d63-321f-4bd2-a653-193f6437c2d2.png)



![Screenshot (457)](https://user-images.githubusercontent.com/96864350/219002198-4f0cc230-3f51-4ab0-9862-96b8168935fe.png)



![Screenshot (458)](https://user-images.githubusercontent.com/96864350/219002366-39558a24-146b-4e3a-8888-7970ec514daf.png)


![Screenshot (459)](https://user-images.githubusercontent.com/96864350/219002398-4d668bfe-a1a9-4082-987c-7c296c897041.png)


If any problem stating url not configured :
Use this: 
        ```<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <scope>provided</scope>
        </dependency>
       ```
        
Also please provide your database settings as well as change create-drop to update if data needs to be persisted.
