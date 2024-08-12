<template>
  <h1 class="filter-headline">Filter By:</h1>
  <JobCardFilter />
</template>

<script>
import JobCardFilter from '../components/JobCardFilter.vue'

export default {
    name: 'job-card-filter-view',
    components: { JobCardFilter },
    data() {
        return {

        }
    }

}
</script>

<style>

</style>