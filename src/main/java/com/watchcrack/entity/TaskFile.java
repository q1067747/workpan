package com.watchcrack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class TaskFile {
    private MyFile file;
    private User user;
}
