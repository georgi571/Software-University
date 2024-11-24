function histogram(input) {
    const n = input[0];

    let p1 = 0;
    let p2 = 0;
    let p3 = 0;
    let p4 = 0;
    let p5 = 0;

    for (let i = 1; i <= input.length; i++) {
        const number = input[i];

        if (number < 200) {
            p1++;
        } else if (number < 400) {
            p2++;
        } else if (number < 600) {
            p3++;
        } else if (number < 800) {
            p4++;
        } else if (number >= 800) {
            p5++;
        }
    }

    const percentP1 = (p1 / n) * 100;
    const percentP2 = (p2 / n) * 100;
    const percentP3 = (p3 / n) * 100;
    const percentP4 = (p4 / n) * 100;
    const percentP5 = (p5 / n) * 100;

    console.log(`${percentP1.toFixed(2)}%`);
    console.log(`${percentP2.toFixed(2)}%`);
    console.log(`${percentP3.toFixed(2)}%`);
    console.log(`${percentP4.toFixed(2)}%`);
    console.log(`${percentP5.toFixed(2)}%`);
}