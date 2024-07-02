function solve(base, increment) {
    let stone = 0;
    let marble = 0;
    let lapis = 0;
    let gold = 0;
    let height = 0;
    let counter = 0;
    for (let i = base; i >= 1; i -= 2) {
        counter++;
        height += increment;
        if (i <= 2) {
            gold += (i ** 2) * increment;
        } else {
            stone += ((i - 2) ** 2) * increment;
            if (counter % 5 === 0) {
                lapis += ((i * 4) - 4) * increment;
            } else {
                marble += ((i * 4) - 4) * increment;
            }
        }
    }
    console.log(`Stone required: ${Math.ceil(stone)}`);
    console.log(`Marble required: ${Math.ceil(marble)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(lapis)}`);
    console.log(`Gold required: ${Math.ceil(gold)}`);
    console.log(`Final pyramid height: ${Math.floor(height)}`);
}