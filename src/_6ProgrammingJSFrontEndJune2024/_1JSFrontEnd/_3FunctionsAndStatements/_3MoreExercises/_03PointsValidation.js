function pointsValidation(points) {
    isInteger(points[0], points[1], 0, 0);
    isInteger(points[2], points[3], 0, 0);
    isInteger(points[0], points[1], points[2], points[3]);

    function isInteger(x1, y1, x2, y2) {
        const check = Number.isInteger(Math.sqrt(((x2 - x1) ** 2) + (y2 - y1) ** 2));
        return printResult(check);
        function printResult(check) {
            if (check) {
                console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`)
            } else {
                console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`)
            }
        }
    }
}