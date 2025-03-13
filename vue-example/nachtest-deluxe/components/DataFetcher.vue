<template>
Fetcher
</template>
<script setup lang="ts">
import { onMounted, defineExpose, ref, computed, toRefs } from 'vue'
import axios from 'axios'

interface Teilnehmer {
    id: number;
    laptop_id: string;
    logged_in: number;
    os: string;
}

const props = defineProps<{
    mockMode?: boolean
}>()

const { mockMode } = toRefs(props)

const teilnehmer = ref([] as Teilnehmer[]);

const emit = defineEmits<{
  (e: 'deleted', value: number): void;
}>();

onMounted(async () => {
  if (mockMode.value) {
    teilnehmer.value = [
      { id: 1, laptop_id: "123", logged_in: 1, os: "Windows" },
      { id: 2, laptop_id: "456", logged_in: 0, os: "Linux" },
      { id: 3, laptop_id: "789", logged_in: 1, os: "Mac" },
    ];
  } else {
    const response = await axios.get("http://matura.at/teilnehmer");
    teilnehmer.value = response.data;
  }
})



const teilnehmerCount = computed(() => {
    return teilnehmer.value.length;
})

async function deleteTeilnehmer(id: number) {
    if (mockMode.value) {
        teilnehmer.value = teilnehmer.value.filter((t) => t.id !== id);
    } else {
    await axios.delete(`http://matura.at/teilnehmer/${id}`);
      
    }
    emit("deleted", id);

}

defineExpose({
    teilnehmer,
    teilnehmerCount,
    deleteTeilnehmer
})

</script>
