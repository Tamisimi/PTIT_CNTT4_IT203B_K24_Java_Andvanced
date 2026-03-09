package session02.hw01;

public class BAI01 {
  /*
[Bài tập] Lựa chọn Functional Interface phù hợp

1. Kiểm tra xem một User có phải là Admin hay không (trả về true/false)
Functional Interface phù hợp: Predicate<User>

Giải thích:
Predicate được sử dụng khi cần kiểm tra một điều kiện và trả về giá trị boolean 
(true hoặc false). Trong trường hợp này hệ thống cần kiểm tra User có phải Admin 
hay không nên Predicate là phù hợp.

2. Chuyển đổi một đối tượng User thành chuỗi String chứa thông tin username
Functional Interface phù hợp: Function<User, String>

Giải thích:
Function được dùng khi cần chuyển đổi dữ liệu từ kiểu này sang kiểu khác.
Ở đây ta chuyển từ đối tượng User sang kiểu String chứa thông tin username.

3. In thông tin chi tiết của User ra màn hình Console
Functional Interface phù hợp: Consumer<User>

Giải thích:
Consumer được sử dụng khi cần thực hiện một hành động với dữ liệu nhưng 
không cần trả về kết quả. Trong trường hợp này là in thông tin User ra màn hình.

4. Khởi tạo một đối tượng User mới với các giá trị mặc định
Functional Interface phù hợp: Supplier<User>

Giải thích:
Supplier được sử dụng khi cần cung cấp hoặc tạo ra một đối tượng mà 
không cần tham số đầu vào. Vì vậy Supplier phù hợp để tạo một User mới 
với các giá trị mặc định.
*/
  
}
