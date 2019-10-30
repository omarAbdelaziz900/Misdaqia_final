package com.example.misdaqia.View.login;

public class LoginResponse {

    /**
     * status : true
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImZhYjBlMWZlNmQ0NDY2Y2MzZGZiMTkwMzI1YmMxNWI3MWI1MmFjOGZlNWFlODA4NWMzNjEwOTVkOGM3N2VjNjZkMmM1YmM0NDkwYWI0OGEwIn0.eyJhdWQiOiIxIiwianRpIjoiZmFiMGUxZmU2ZDQ0NjZjYzNkZmIxOTAzMjViYzE1YjcxYjUyYWM4ZmU1YWU4MDg1YzM2MTA5NWQ4Yzc3ZWM2NmQyYzViYzQ0OTBhYjQ4YTAiLCJpYXQiOjE1NzI0Mzc5NjEsIm5iZiI6MTU3MjQzNzk2MSwiZXhwIjoxNjA0MDYwMzYxLCJzdWIiOiIzOCIsInNjb3BlcyI6WyJ1c2VyIl19.VL8BvCnAzIfF6y-SnB4-lULBCmowvKnYBNybIqiY8UY4n30-i-SEA6OL4XaYdj2AiFTl1GoMJ02L4YlHj7MjS0ak0fhhmyM8RjKApYNmMk-o1VzwevHptSKZnTYVYTZljfwqEuVEtp-bdtTgcsHmYJ7Xqpqqi_hIU30JWG_QdCCw3xRS7p0EmXgMh5FV393ePdGRZnuZRFcvWoFy8dvbu_bW8ZCI7QhZMrX94-ZjaTIo7VxtopWipnmQRHUlrFovdyceJIQgxIOvfO6OzWT-TbdHqC13Od7y9z9oba6OPcCeDoIFhuPIefO3pr9b5M0lujjbRx56en1rTMe-8MhIz5L8OxLxQsuPI_hZo3RyGUaEJpGzxXZxbFTsvsuIJI22HcccJYg2xvtzEgwwtwbSFgzt2ROthdhYAO05MOAOJSsFnwfKNU_PgubVUjBd6vBJTvr2EQ4vVEwq4FFrgrFt1vOqoHBSPipV8Hiz5y17Ji0qbjYyX3pRIa-BrOXneeIPf9MazBirkdfyCa7ZSSAjq-g5nogmVwFJuImyd9RD9yrNQss1Rmg_yklodzDEZo0eiCr2cZ9DR_Pppu6SKkyXX4ooRfDIFm0WgsET50H6viuA1YFtgJF2wSkGh-J3X9r3-WQBSqyI9SuW2YPkXpP3cnwaQxtP5GB2kiQfwwPs3HI
     * user : {"id":38,"name":"ertert","email":"ert@gmail.com","email_verified_at":null,"role":"user","phone":"011123654","created_at":"2019-10-30 11:22:46","updated_at":"2019-10-30 11:22:46"}
     */

    private boolean status;
    private String token;
    private UserBean user;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id : 38
         * name : ertert
         * email : ert@gmail.com
         * email_verified_at : null
         * role : user
         * phone : 011123654
         * created_at : 2019-10-30 11:22:46
         * updated_at : 2019-10-30 11:22:46
         */

        private int id;
        private String name;
        private String email;
        private Object email_verified_at;
        private String role;
        private String phone;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getEmail_verified_at() {
            return email_verified_at;
        }

        public void setEmail_verified_at(Object email_verified_at) {
            this.email_verified_at = email_verified_at;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
