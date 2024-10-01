package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.JobCardDao;
import com.dzt.job_card.Models.JobCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class JobCardController {

    @Autowired
    JobCardDao jobCardDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add-card")
    public JobCard addJobCard(@RequestBody JobCard card) {
        JobCard newCard = jobCardDao.createNewJobCard(card);
        if(newCard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to create new card");
        } else {
            return newCard;
        }
    }

    @GetMapping("/job-cards/{id}")
    public JobCard getCardById(@PathVariable int id) {
        return jobCardDao.getCardById(id);
    }

    @GetMapping("/job-cards")
    public List<JobCard> getAllJobCards() {
        return jobCardDao.getAllJobCards();
    }

    @GetMapping("/job-cards-by-num/{jobNum}")
    public List<JobCard> filterCardsByNumber(@PathVariable Integer jobNum) {
        return jobCardDao.filterByNumber(jobNum);
    }

    // Should I pass in another way to hide client names??
    @GetMapping("/job-cards-by-name/{name}")
    public List<JobCard> filterCardsByName(@PathVariable String name) {
        return jobCardDao.filterByName(name);
    }

    @GetMapping("/job-cards-by-type/{type}")
    public List<JobCard> filterCardsByType(@PathVariable String type) {
        return jobCardDao.filterByType(type);
    }

    @PutMapping("/job-cards") // you can put methods in same endpoint w/diff http requests
    public JobCard editCard(@RequestBody JobCard card) {
        JobCard updatedCard = jobCardDao.editJobCard(card);
        if(updatedCard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "card not found");
        } else {
            return updatedCard;
            }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/job-cards/{id}") // throw exception here??
    public boolean deleteCard(@PathVariable int id) {
        return jobCardDao.deleteJobCard(id);
    }
}