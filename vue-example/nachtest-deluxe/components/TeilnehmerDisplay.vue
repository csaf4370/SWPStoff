<template>
<span>
  {{  id  }}
  {{  laptop_id  }}
  {{  logged_in  }}
  {{  os  }}
</span>
</template>

<script setup lang="ts">
import { defineProps  } from 'vue';

defineProps<{
    id: number;
    laptop_id: string,
    logged_in: number,
    os: string
}>();

// const { id, laptop_id, logged_in, os } = toRefs(props);

</script>
