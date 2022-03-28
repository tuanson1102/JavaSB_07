function calculateFactorial(number) {
        let giai_thua = 1;
        if (number == 0 || number == 1) {
            console.log(giai_thua);          
        }else{
            for (let i = 2; i <= number; i++) {
                giai_thua*=i;
            }
            console.log(giai_thua);
        }
}

function reverseString(string) {
    let array = string.split("")
    let reverse= array.reverse()
    let newString = reverse.join("")
    console.log(newString);
}

function translate(countryCode) {
    switch (countryCode) {
        case "VN":
            console.log("Xin Chào")
            break;
        case "EN":
            console.log("Hello")
            break;
        case "IT":
            console.log("Ciao")
            break;
        case "TL":
            console.log("สวัสดี")
        break;
    }
}

function subString(s) {
    char=s.substring(0,10)
    console.log(char+"...")
}


calculateFactorial(6)
reverseString("hello")
translate("TL")
subString("Techmasterxinchaocacban") 
