function areaOfFigures(figureType, first, second) {
    let area;
    if (figureType === "square") {
        const a = first;
        area = a * a;
    } else if (figureType === "rectangle") {
        const a = first;
        const b = second;
        area = a * b;
    } else if (figureType === "circle") {
        const r = first;
        area = r * r * Math.PI;
    } else if (figureType === "triangle") {
        const a = first;
        const h = second;
        area = (a * h) / 2;
    }
    console.log(`${area.toFixed(3)}`)
}