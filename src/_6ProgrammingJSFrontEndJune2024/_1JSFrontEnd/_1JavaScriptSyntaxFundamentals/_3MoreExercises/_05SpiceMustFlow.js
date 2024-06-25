function solve(yield) {
    let spices = 0;
    let days = 0;
    while (yield >= 100) {
        spices += yield - 26;
        if (spices < 0) {
            spices = 0;
        }
        yield -= 10;
        days++;
    }
    spices -= 26;
    if (spices < 0) {
        spices = 0;
    }
    console.log(days);
    console.log(spices);
}