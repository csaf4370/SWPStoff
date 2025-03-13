<template>
  <q-page class="row items-center justify-evenly">
    <data-fetcher ref="fetcherRef" mock-mode></data-fetcher>
    <span>
      Logged in:
      {{ fetcherRef?.teilnehmerCount }}
    </span>
    <ul>
      <li v-for="teilnehmer in fetcherRef?.teilnehmer" :key="teilnehmer.id">
        <teilnehmer-display :id="teilnehmer.id" :laptop_id="teilnehmer.laptop_id" :logged_in="teilnehmer.logged_in" :os="teilnehmer.os"></teilnehmer-display>
        <button @click="fetcherRef?.deleteTeilnehmer(teilnehmer.id)">LÖSCHEN</button>
      </li>
    </ul>
  </q-page>
</template>

<script setup lang="ts">
import DataFetcher from 'components/DataFetcher.vue'
import TeilnehmerDisplay from 'components/TeilnehmerDisplay.vue'
import { useTemplateRef } from 'vue';

const fetcherRef = useTemplateRef<typeof DataFetcher>("fetcherRef");
</script>
