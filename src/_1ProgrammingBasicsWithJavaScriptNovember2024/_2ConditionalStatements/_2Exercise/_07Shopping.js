function shopping(budged, numberOfVideoCards, numberOfProcessors, numberOfRamMemory) {
    const PERCENT_DISCOUNT_IF_VIDEOCARS_IS_MORE_THAN_PROCESSORS = 0.15;

    const VIDEOCARD_PRICE = 250;
    const PROCESSOR_PRICE_PERCENT = 0.35;
    const RAM_MEMORY_PRICE_PERCENT = 0.10;

    const sumForVideoCards = numberOfVideoCards * VIDEOCARD_PRICE;
    const priceForProcessor = sumForVideoCards * PROCESSOR_PRICE_PERCENT;
    const sumForProcessors = numberOfProcessors * priceForProcessor;
    const priceForRamMemory = sumForVideoCards * RAM_MEMORY_PRICE_PERCENT;
    const sumForRamMemory = numberOfRamMemory * priceForRamMemory;
    let totalSum = sumForRamMemory + sumForProcessors + sumForVideoCards;

    if (numberOfVideoCards > numberOfProcessors) {
        totalSum = totalSum - (totalSum * PERCENT_DISCOUNT_IF_VIDEOCARS_IS_MORE_THAN_PROCESSORS);
    }

    const diff = Math.abs(totalSum - budged);
    if (budged >= totalSum) {
        console.log(`You have ${diff.toFixed(2)} leva left!`);
    } else {
        console.log(`Not enough money! You need ${diff.toFixed(2)} leva more!`);
    }
}