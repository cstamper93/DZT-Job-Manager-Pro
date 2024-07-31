package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.FieldEntryDao;
import com.dzt.job_card.Models.FieldEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class FieldEntryController {

    @Autowired
    FieldEntryDao fieldEntryDao;

    @GetMapping("/field-entries/{id}")
    public List<FieldEntry> getFieldEntriesWithJobId(@PathVariable int id) {
        List<FieldEntry> fieldEntries = fieldEntryDao.getFieldEntriesByJobId(id);
        if(fieldEntries == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Field entries not found");
        } else {
            return fieldEntries;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("field-entries")
    public boolean addFieldEntry(@RequestBody FieldEntry entry) {
        return fieldEntryDao.createFieldEntry(entry);
    }

    @PutMapping("/field-entries")
    public FieldEntry updateFieldEntry(@RequestBody FieldEntry entry) {
        FieldEntry updatedEntry = fieldEntryDao.editFieldEntry(entry);
        if(updatedEntry == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Field entry not found");
        } else {
            return updatedEntry;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/field-entries")
    public boolean deleteEntry(@RequestBody FieldEntry entry) {
        return fieldEntryDao.deleteFieldEntry(entry.getJobId(), entry.getEntryDate(), entry.getCrewName1());
    }

}
