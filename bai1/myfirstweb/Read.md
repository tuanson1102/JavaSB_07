1. Các tham số:
groupID tên của công ty hoặc nhóm đã tạo ra dự án
artifactID tên riêng của dự án
2. Dễ tìm kiếm project 
3. 2 cơ chế để quản lý thư viện SpringBoot : Maven và Gradle
4. File pom.xml để cấu hình ứng dụng
5. Trong file pom.xml có các thẻ dependency là các thư viện đã thêm vào từ lúc đầu tạo dự án 
6. @Controller là nơi tiếp nhận các thông tin request từ phía người dùng. Nó có nhiệm vụ đón nhận các yêu cầu (kèm theo thông tin request) và chuyển các yêu cầu này xuống cho tầng @Serivce xử lý logic
7. @RequestMappinglà nơi tạo đường dẫn dẫn đến phần trang web . Ngoài thuộc tính value ta có thêm 3 thuộc tính method , headers và produces
8. @RequestResponse đặt trong hàm hứng request để yêu cầu trả về luôn trực tiếp
9. @PathVariable dùng khi trích xuất giá trị dưới dạng key-value @RequestParam trích xuất nguyên văn URL
10. @PathVariable có thể thay đổi được chỉ cần là đúng key-value 
11. @GetMapping tạo ra đường dẫn của phương thức lấy dữ liệu @PostMapping tạo ra đường dẫn cửa phương thức Post dữ liệu
12. Thông số produces để định hình kiểu dữ liệu trả về
13. Giống như @PathVariable tuy nhiên @RequestBody sẽ lấy toàn bộ dữ liệu của toàn class message dưới dạng key value(Chuyển thành 1 Java object)
14. Có thể đổi cổng truy cập ứng dụng tại application.property với thuộc tính sever.port: