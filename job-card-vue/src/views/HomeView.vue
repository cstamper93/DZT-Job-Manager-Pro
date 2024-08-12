<template>
  <main>
    <h1 class="home-title">Jobs List</h1>

    <button class="add-button" @click="isVisible = !isVisible" v-if="isVisible">+ Add Card</button>
    <button class="add-button" @click="isVisible = !isVisible" v-if="!isVisible">Cancel</button>

    <router-link v-bind:to="{name: 'Job-Card-Filter'}">
    <button class="filter-btn">Filter  <img src="../components/icons/filter.png" alt="Filter Icon" /></button>
    </router-link>

    <AddCard v-if="!isVisible"/>
    <JobCardsList />
  </main>

  <footer>
        <p>Icons by Freepik from <a href="www.flaticon.com">flaticon.com</a></p>
    </footer>
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
      showfilterBtn: true
    };
  }
}
</script>

<style scoped>

img {
  width: 0.75rem;
  height: 0.75rem;
  margin-left: 0.2rem;
}

</style>

