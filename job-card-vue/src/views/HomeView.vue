<template>
  <main>
    <h1 class="home-title">Job Board</h1>

    <button class="add-button" @click="isVisible = !isVisible" v-if="isVisible">+ Add Card</button>
    <button class="add-button" @click="isVisible = !isVisible" v-if="!isVisible">Cancel</button>

    <AddCard v-if="!isVisible"/>
    <JobCardsList />
  </main>
</template>

<script>
import JobCardsList from '../components/JobCardsList.vue'
import AddCard from '../components/AddCard.vue'

export default {
  name: 'home-view',
  components: {
    JobCardsList,
    AddCard
  },
  data() {
    return {
      isVisible: true,
    };
  }
}
</script>

<style scoped>

</style>

