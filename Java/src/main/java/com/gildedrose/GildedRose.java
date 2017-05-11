package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateInventory() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            //do nothing
        } else {
            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePasses(item);
                    break;
                default:
                    updateNormalItem(item);
                    break;
            }
            if (item.quality < 0) {
                item.quality = 0;
            }
            if (item.quality > 50) {
                item.quality = 50;

            }
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateNormalItem(Item item) {
        decreaseQuality(item);
        if (item.sellIn <= 0) {
            decreaseQuality(item);
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 0) increaseQuality(item);
    }


    private void updateBackstagePasses(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality = item.quality + 3;
        } else if (item.sellIn <= 10) {
            item.quality = item.quality + 2;
        } else {
            increaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}