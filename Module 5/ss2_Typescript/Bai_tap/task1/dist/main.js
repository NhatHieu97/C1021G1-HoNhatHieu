let sum = 0;
let count = 0;
for (let i = 1; i < 30; i++) {
    sum += fibonacci(i);
    count++;
}
function fibonacci(num) {
    if (num <= 1)
        return 1;
    return fibonacci(num - 1) + fibonacci(num - 2);
}
console.log("Tổng số fibonacci: " + sum + "Số lần: " + count);
//# sourceMappingURL=main.js.map