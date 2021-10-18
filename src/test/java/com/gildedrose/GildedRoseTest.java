package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("Test that date gets updated")
  void testDateUpdated() {
    Item element = new Item("foo", 5, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn,equalTo(4));
  }


  @Test
  @DisplayName("Test that quality gets updated")
  void testQualityUpdated() {
    Item element = new Item("foo", 5, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,equalTo(1));
  }


  // Tester la qualité aprés la date de péremption et verifier qu'elle se egrade deux fois plus
  @Test
  @DisplayName("Test that quality gets updated after end date twice the speed")
  void testQualityAfterEnddate() {
    Item element = new Item("foo", 1, 8);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    // date = 0 , quality = 7
    app.updateQuality();
    assertThat(element.quality,equalTo(5));
  }


  @Test
  @DisplayName("Test that quality is and stays positive")
  void testPositive() {
    Item element = new Item("foo", 5, 1);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,greaterThanOrEqualTo(0));
    app.updateQuality();
    assertThat(element.quality,greaterThanOrEqualTo(0));
  }


  @Test
  @DisplayName("Test that Aged Brie's quality adds with time")
  void testAgedBrieQuality() {
    Item element = new Item("Aged Brie", 5, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,greaterThan(4));

  }


  @Test
  @DisplayName("Test quality top is 50")
  void testQualityTop() {
    // we use Aged Brie to see that even when quality adds it dosen't surpass 50
    Item element = new Item("Aged Brie", 5, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,equalTo(50));
  }


  @Test
  @DisplayName("Test on Sulfuras quality unchanged with date")
  void testSulfurasQuality() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,equalTo(80));

  }

  @Test
  @DisplayName("Test that Sulfuras have no resumption date")
  void testSulfurasResumptionDate() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 3, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn,equalTo(3));

  }

  @Test
  @DisplayName("Test that Backstage passes's quality adds with time")
  void testBackstagePassesQuality() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,greaterThan(4));

  }

  @Test
  @DisplayName("Test that Backstage passes's quality adds 2 with time when 10 days or less are left")
  void testBackstagePassesQuality2() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,equalTo(6));
    app.updateQuality();
    assertThat(element.quality,equalTo(8));
  }

  @Test
  @DisplayName("Test that Backstage passes's quality adds 3 with time when 5 days or less are left")
  void testBackstagePassesQuality3() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,equalTo(7));
    app.updateQuality();
    assertThat(element.quality,equalTo(10));
  }

  @Test
  @DisplayName("Test that Backstage passes's quality lowers to 0 after concert date")
  void testBackstagePassesQuality4() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,equalTo(0));

  }

  @Test
  @DisplayName("Test that quality of Conjured lowers by 2 with time")
  void testConjuredQuality() {
    Item element = new Item("Conjured Mana Cake", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality,equalTo(47));
  }

}
