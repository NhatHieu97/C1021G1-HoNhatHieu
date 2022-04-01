// @ts-ignore
// function fibonacci(num) {
//     if (num <= 1)
//         return 1;
//     return fibonacci(num - 1) + fibonacci(num - 2);
// }
//
// let sum = 0;
// let count = 0;
// for (let i = 1; i < 10; i++){
//     sum += fibonacci(i);
//     count++
// }
//
// console.log(sum)
function fibonaccii(num) {
    var a = 1;
    var b = 0;
    var temp;
    while (num >= 0) {
        temp = a;
        a = a + b;
        num--;
    }
    return b;
}
fibonaccii(10);
