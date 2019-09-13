# backendAssignment

SQL Query for setup database "backenddeveloperassignment"

REVINFO
CREATE TABLE `revinfo` (
  `rev` int(11) NOT NULL,
  `revtstmp` bigint(20) DEFAULT NULL
) 

CREATE TABLE `notes_aud` (
  `id` int(11) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL
) 

CREATE TABLE `notes` (
  `id` int(11) NOT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL
)
