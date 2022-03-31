// Khởi tạo object
// let user = {
//     name: "Nguyễn Văn A",
//     age: 23,
//     email: "abc@gmail.com",

//     sayHello(){
//         console.log("xin chào");
//     },
//     eat(food){
//         console.log(`ăn món ${food}`);
//     }
// }
// truy cập vào thuộc tính
// console.log(user.name);
// console.log(user["age"]);
// user.sayHello();
// user.eat("phở");

// set lại giá trị
// user.name = "ngô b";
// console.log(user);

//lặp object
// let keys = Object.keys(user); // trả về mảng các keys

// for (let i = 0; i < keys.length; i++) {
//     console.log(user[keys[i]]);
    
// }

//cách lặp thứ 2
// for (const key in user) {
//     console.log(user[key]);
// }

// Danh sách các sản phẩm có trong giỏ hàng
let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 30000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]
// Hiển thị tất cả sản phẩm
function displayInfo(arr){
    arr.forEach(product=>{
        console.log(`${product.name}-${product.price}-${product.brand}-${product.count}`)     
    })
}

// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product
function addProduct(name , price , brand , count) {
    let item = {
          name: name,
          price:  price,
          brand: brand,
          count:  count,
    }; 
    products.push(item);
    console.log(products);
}
addProduct("Iphone XSMax" , 25000000 , "Apple" , 5); 
// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng
function removeByProduct(arr) {
    let brand = "Samsung"; 
    let newArr = arr.filter(product => brand != product.brand);
    return newArr; 
}
console.log(removeByProduct(products)); 
// 8. Sắp xếp giỏ hàng theo price tăng dần
products.sort(function (a, b) {
    return a.price - b.price;
}); 
console.log(products);
// 9. Sắp xếp giỏ hàng theo count giảm dần
products.sort(function (a, b) {
    return b.count - a.count; 
})
console.log(products);
// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
function getProduct(arr) {
    let newArr = []
    while (newArr.length < 2){
        let random = Math.floor(Math.random() * arr.length);
        if(newArr.includes(arr[random]) == false) {
            newArr.push(arr[random]);
        }
    }
    return newArr;
}
console.log(getProduct(products));