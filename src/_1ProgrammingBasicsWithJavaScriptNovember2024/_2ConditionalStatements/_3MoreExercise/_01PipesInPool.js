function pipesInPool(v, p1, p2, h) {
    const firstPipeWater = p1 * h;
    const secondPipeWater = p2 * h;
    const totalAmountOfWater = firstPipeWater + secondPipeWater;

    const diff = Math.abs(v - totalAmountOfWater);
    const percent = (totalAmountOfWater / v) * 100;
    const percentP1 = (firstPipeWater / totalAmountOfWater) * 100;
    const percentP2 = (secondPipeWater / totalAmountOfWater) * 100;

    if (v >= totalAmountOfWater) {
        console.log(`The pool is ${percent.toFixed(2)}% full. Pipe 1: ${percentP1.toFixed(2)}%. Pipe 2: ${percentP2.toFixed(2)}%.`);
    } else {
        console.log(`For ${h.toFixed(2)} hours the pool overflows with ${diff.toFixed(2)} liters.`);
    }
}