function printDNA (number) {
    const dna = 'ATCGTTAGGG'.split('');
    let index = 0;
    let currentDNA = 1;
    for (let i = 0; i < number; i++) {
        if (currentDNA === 4) {
            console.log(`*${dna[index]}--${dna[index + 1]}*`);
        } else if (currentDNA === 3) {
            console.log(`${dna[index]}----${dna[index + 1]}`);
        } else if (currentDNA === 2) {
            console.log(`*${dna[index]}--${dna[index + 1]}*`);
        } else {
            console.log(`**${dna[index]}${dna[index + 1]}**`);
        }
        index += 2;
        if (index === 10) {
            index = 0;
        }
        currentDNA++;
        if (currentDNA === 5) {
            currentDNA = 1;
        }
    }
}