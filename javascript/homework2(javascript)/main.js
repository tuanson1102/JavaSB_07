// câu 1
const text = document.getElementById("text");
text.style.color = "#777";
text.style.fontSize = "2rem";
text.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript"
// câu 2 
const li = document.querySelectorAll("body > ul:nth-child(2) > li");
for (let i = 0; i < li.length; i++){
    li[i].style.color = "blue";
}
// câu 3
//Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
const ul2 = document.getElementById("list")
const li8 = document.createElement("li")
li8.innerText = "Item 8"
const li9 = document.createElement("li")
li9.innerText = "Item 9"
const li10 = document.createElement("li")
li10.innerText = "Item 10"
ul2.insertAdjacentElement("beforeend",li8);
ul2.insertAdjacentElement("beforeend",li9);
ul2.insertAdjacentElement("beforeend",li10);

//Sửa nội dung cho thẻ <li> 1 thành màu đỏ (color)
const li1 = document.querySelector("#list > li:nth-child(1)")
li1.style.color = "red";

//Sửa background cho thẻ <li> 3 thành màu xanh (background-color)
const li3 = document.querySelector("#list > li:nth-child(3)")
li3.style.backgroundColor = "blue";

//Remove thẻ <li> 4
const li4 = document.querySelector("#list > li:nth-child(4)")
li4.remove();

//Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ
const newLi4 = document.createElement("li")
newLi4.innerText = "phần tử mới"
li3.insertAdjacentElement("afterend",newLi4);
