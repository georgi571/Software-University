function solve(x1, y1, x2, y2) {
    let result1 = Math.sqrt(((0 - x1) ** 2) + ((0 - y1) ** 2));
    let result2 = Math.sqrt(((x2 - 0) ** 2) + ((y2 - 0) ** 2));
    let result3 = Math.sqrt(((x2 - x1) ** 2) + ((y2 - y1) ** 2));
    if (Number.isInteger(result1)) {
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    }
    if (Number.isInteger(result2)) {
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`);
    } else {
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
    }
    if (Number.isInteger(result3)) {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
    }
}