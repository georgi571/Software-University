function housePainting(x, y, h) {
    const wall1 = x * x;
    const wall2 = (x * x) - (1.2 * 2);
    const wall3 = (x * y) - (1.5 * 1.5);
    const wall4 = (x * y) - (1.5 * 1.5);
    const roof1 = x * y;
    const roof2 = x * y;
    const roof3 = (x * h) / 2;
    const roof4 = (x * h) / 2;
    const walls = wall1 + wall2 + wall3 + wall4;
    const roofs = roof1 + roof2 + roof3 + roof4;
    const paintForWalls = walls / 3.4;
    const paintForRoofs = roofs / 4.3;

    console.log(`${paintForWalls.toFixed(2)}`)
    console.log(`${paintForRoofs.toFixed(2)}`)
}