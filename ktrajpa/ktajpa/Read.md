## Câu 1:
- Giữa @Entity(name = ‘EntityName’) và @Table(name = “TableName”) thì ta có @Entity(name = ‘EntityName’) dùng để chỉ tên của entity được Hibernate quản lý còn @Table(name = “TableName”) chỉ tên của table dưới database.

## Câu 2:
`spring.jpa.show-sql=true`

## Câu 3:
- Chúng ta đặt đường dẫn tới nơi truy vấn cơ sở dữ liệu trong file application.properties là `spring.h2.console.path=/h2-console`, thì đường dẫn tới nơi truy vấn cơ sở dữ liệu là /h2-console có liên quan đến địa chỉ và cổng đang chạy của chúng ta. Do đó, nếu  chúng ta đang chạy tại cổng http://localhost:8080, thì truy cập vào CSDL bằng link http://localhost:8080/h2-console.

## Câu 4:
- chúng ra sẽ đánh dấu bằng :`@Transient`

## Câu 5:
- Để đặt lại tên cột sử dụng annotation @Column(name=“ten_cot”)
- tham số chỉ định yêu cầu duy nhất sử dụng annotation @Column(unique)
- không được trùng lặp dữ liệu sử dụng annotation @Column(distinct)
- tham số buộc trường không được null sử dụng annotation @Column(nullable = false) hoặc @NotNull

## Câu 6:
- đó là 2 annotation @PrePersist và @PreUpdate

## Câu 7:
- đó là 2 annotation @Embeddable và @Embedded

## Câu 8:
- JpaRepository kế thừa từ interface PagingAndSortingRepository

## Câu 9: 
```java
    @Repository
    public interface PostRepo extends JpaRepository<Post,Long>
```
## Câu 10: 
- Không

## Câu 11:
- @Id primary key cần giữ nguyên không đổi
  @NaturalId có thể được phép thay đổi, miễn đảm bảo duy nhất

## Câu 12:
- 

## Câu 13:
- Chúng ta có thể sử dụng UUID hoặc @NaturalId

## Câu 14: