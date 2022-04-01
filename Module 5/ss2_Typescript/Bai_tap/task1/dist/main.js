function fibonaccii(num) {
    let a = 1;
    let b = 0;
    let temp;
    while (num >= 0) {
        temp = a;
        a = a + b;
        num--;
    }
    return b;
}
console.log(fibonaccii(10));
//# sourceMappingURL=main.js.map