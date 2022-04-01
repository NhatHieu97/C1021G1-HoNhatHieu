


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

function fibonacci(num: number) {
    let a = 1;
    let b = 0;
    let temp = 0;
    while (num >= 0){
        temp = a;
        a = a + b;
        b = temp;
        num--;
    }
    return b;

}

console.log(fibonacci(10));
