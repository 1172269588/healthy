package com.wd.mvp.model.bean;

import java.util.List;

public class SearchBean {

    /**
     * result : {"diseaseSearchVoList":[{"diseaseId":123,"diseaseName":"新生儿黄疸"}],"doctorSearchVoList":[{"doctorId":1,"doctorName":"张医生"},{"doctorId":68,"doctorName":"张先生"},{"doctorId":84,"doctorName":"李医生"},{"doctorId":85,"doctorName":"何医生"},{"doctorId":87,"doctorName":"李医生"}],"drugsSearchVoList":[{"drugsId":59,"drugsName":" [小施尔康]小儿多维生素咀嚼片(10) "},{"drugsId":84,"drugsName":" [首儿]小儿生血糖浆 "},{"drugsId":86,"drugsName":" [小施尔康]小儿多维生素咀嚼片(10) "},{"drugsId":87,"drugsName":" [养生堂]毛绒玩具(赠品 随机) "},{"drugsId":92,"drugsName":" [伊可新]维生素AD滴剂(胶囊型 1岁以上) "}]}
     * message : 搜索成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        private List<DiseaseSearchVoListBean> diseaseSearchVoList;
        private List<DoctorSearchVoListBean> doctorSearchVoList;
        private List<DrugsSearchVoListBean> drugsSearchVoList;

        public List<DiseaseSearchVoListBean> getDiseaseSearchVoList() {
            return diseaseSearchVoList;
        }

        public void setDiseaseSearchVoList(List<DiseaseSearchVoListBean> diseaseSearchVoList) {
            this.diseaseSearchVoList = diseaseSearchVoList;
        }

        public List<DoctorSearchVoListBean> getDoctorSearchVoList() {
            return doctorSearchVoList;
        }

        public void setDoctorSearchVoList(List<DoctorSearchVoListBean> doctorSearchVoList) {
            this.doctorSearchVoList = doctorSearchVoList;
        }

        public List<DrugsSearchVoListBean> getDrugsSearchVoList() {
            return drugsSearchVoList;
        }

        public void setDrugsSearchVoList(List<DrugsSearchVoListBean> drugsSearchVoList) {
            this.drugsSearchVoList = drugsSearchVoList;
        }

        public static class DiseaseSearchVoListBean {
            /**
             * diseaseId : 123
             * diseaseName : 新生儿黄疸
             */

            private int diseaseId;
            private String diseaseName;

            public int getDiseaseId() {
                return diseaseId;
            }

            public void setDiseaseId(int diseaseId) {
                this.diseaseId = diseaseId;
            }

            public String getDiseaseName() {
                return diseaseName;
            }

            public void setDiseaseName(String diseaseName) {
                this.diseaseName = diseaseName;
            }
        }

        public static class DoctorSearchVoListBean {
            /**
             * doctorId : 1
             * doctorName : 张医生
             */

            private int doctorId;
            private String doctorName;

            public int getDoctorId() {
                return doctorId;
            }

            public void setDoctorId(int doctorId) {
                this.doctorId = doctorId;
            }

            public String getDoctorName() {
                return doctorName;
            }

            public void setDoctorName(String doctorName) {
                this.doctorName = doctorName;
            }
        }

        public static class DrugsSearchVoListBean {
            /**
             * drugsId : 59
             * drugsName :  [小施尔康]小儿多维生素咀嚼片(10)
             */

            private int drugsId;
            private String drugsName;

            public int getDrugsId() {
                return drugsId;
            }

            public void setDrugsId(int drugsId) {
                this.drugsId = drugsId;
            }

            public String getDrugsName() {
                return drugsName;
            }

            public void setDrugsName(String drugsName) {
                this.drugsName = drugsName;
            }
        }
    }
}
