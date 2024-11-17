function pointOnRectangleBorder(x1, y1, x2, y2, x, y) {
    if (y === y1 || y === y2) {
        if (x >= x1 && x <= x2) {
            console.log(`Border`);
        } else {
            console.log(`Inside / Outside`);
        }
    } else if (x === x1 || x === x2) {
        if (y >= y1 && y <= y2) {
            console.log(`Border`);
        } else {
            console.log(`Inside / Outside`);
        }
    } else {
        console.log(`Inside / Outside`);
    }
}