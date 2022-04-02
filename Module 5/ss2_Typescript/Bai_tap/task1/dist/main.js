function fibonacci(num) {
    let a = 1;
    let b = 0;
    let temp = 0;
    while (num >= 0) {
        temp = a;
        a = a + b;
        b = temp;
        num--;
    }
    return b;
}
console.log(fibonacci(10));
//# sourceMappingURL=main.js.map