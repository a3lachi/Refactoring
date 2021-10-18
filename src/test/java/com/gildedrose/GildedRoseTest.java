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




}
