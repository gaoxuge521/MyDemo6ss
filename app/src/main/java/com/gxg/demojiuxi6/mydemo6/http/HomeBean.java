package com.gxg.demojiuxi6.mydemo6.http;

import java.util.List;

/**
 * Created by jiuxi on 17/6/29.
 */

public class HomeBean {

    private List<BannersBean> banners;
    private List<AdvertisementBean> advertisement;
    private List<CasesBean> cases;
    private List<BoutiqueActivityBean> boutiqueActivity;
    private List<InformationBean> information;
    private List<WeddingStepBean> weddingStep;

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public List<AdvertisementBean> getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(List<AdvertisementBean> advertisement) {
        this.advertisement = advertisement;
    }

    public List<CasesBean> getCases() {
        return cases;
    }

    public void setCases(List<CasesBean> cases) {
        this.cases = cases;
    }

    public List<BoutiqueActivityBean> getBoutiqueActivity() {
        return boutiqueActivity;
    }

    public void setBoutiqueActivity(List<BoutiqueActivityBean> boutiqueActivity) {
        this.boutiqueActivity = boutiqueActivity;
    }

    public List<InformationBean> getInformation() {
        return information;
    }

    public void setInformation(List<InformationBean> information) {
        this.information = information;
    }

    public List<WeddingStepBean> getWeddingStep() {
        return weddingStep;
    }

    public void setWeddingStep(List<WeddingStepBean> weddingStep) {
        this.weddingStep = weddingStep;
    }

    public static class BannersBean {
        /**
         * nodeId : 1437
         * nodeName : 婚纱专题
         * image : http://images.9xi.com/103ebf36-d697-4ee6-b87c-69407ad2ef30_750_600.jpeg
         * link : http://123.56.77.94:8080/activity/hslf/hslf.html
         * parentId : 13
         * bizId : 14
         * nodeType : 96
         * bizType : 262
         * logoUrl : http://images.9xi.com/0a50e8ad-39ea-4458-8c7c-cb06e74b47e1_584_612.png
         * price : null
         * extraParams : null
         * enName : null
         * childrens : null
         * url : http://123.56.77.94:8080/htm/goods/1153448.html?goodsId=1153448
         * mprice : 0
         * tags : 小清新
         * likes : 0
         * remarks : null
         * calPrice : 100
         */

        private int nodeId;
        private String nodeName;
        private String image;
        private String link;
        private int parentId;
        private int bizId;
        private int nodeType;
        private int bizType;
        private String logoUrl;
        private Object price;
        private Object extraParams;
        private Object enName;
        private Object childrens;
        private String url;
        private String mprice;
        private String tags;
        private String likes;
        private Object remarks;
        private String calPrice;

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public String getNodeName() {
            return nodeName;
        }

        public void setNodeName(String nodeName) {
            this.nodeName = nodeName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getNodeType() {
            return nodeType;
        }

        public void setNodeType(int nodeType) {
            this.nodeType = nodeType;
        }

        public int getBizType() {
            return bizType;
        }

        public void setBizType(int bizType) {
            this.bizType = bizType;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public Object getExtraParams() {
            return extraParams;
        }

        public void setExtraParams(Object extraParams) {
            this.extraParams = extraParams;
        }

        public Object getEnName() {
            return enName;
        }

        public void setEnName(Object enName) {
            this.enName = enName;
        }

        public Object getChildrens() {
            return childrens;
        }

        public void setChildrens(Object childrens) {
            this.childrens = childrens;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMprice() {
            return mprice;
        }

        public void setMprice(String mprice) {
            this.mprice = mprice;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getLikes() {
            return likes;
        }

        public void setLikes(String likes) {
            this.likes = likes;
        }

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }

        public String getCalPrice() {
            return calPrice;
        }

        public void setCalPrice(String calPrice) {
            this.calPrice = calPrice;
        }
    }

    public static class AdvertisementBean {
        /**
         * nodeId : 1119
         * nodeName : 京东白条
         * image : http://images.9xi.com/c496dcc7-0dfa-4973-a849-5fa6c6d63c06_1035_300.png
         * link : http://123.56.77.94:8080/htm/html/recommend/details_jingdongbaitiao.html
         * parentId : 1099
         * bizId : 346
         * nodeType : 96
         * bizType : 71
         * logoUrl : null
         * price : null
         * extraParams : null
         * enName : null
         * childrens : null
         */

        private int nodeId;
        private String nodeName;
        private String image;
        private String link;
        private int parentId;
        private int bizId;
        private int nodeType;
        private int bizType;
        private Object logoUrl;
        private Object price;
        private Object extraParams;
        private Object enName;
        private Object childrens;

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public String getNodeName() {
            return nodeName;
        }

        public void setNodeName(String nodeName) {
            this.nodeName = nodeName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getNodeType() {
            return nodeType;
        }

        public void setNodeType(int nodeType) {
            this.nodeType = nodeType;
        }

        public int getBizType() {
            return bizType;
        }

        public void setBizType(int bizType) {
            this.bizType = bizType;
        }

        public Object getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(Object logoUrl) {
            this.logoUrl = logoUrl;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public Object getExtraParams() {
            return extraParams;
        }

        public void setExtraParams(Object extraParams) {
            this.extraParams = extraParams;
        }

        public Object getEnName() {
            return enName;
        }

        public void setEnName(Object enName) {
            this.enName = enName;
        }

        public Object getChildrens() {
            return childrens;
        }

        public void setChildrens(Object childrens) {
            this.childrens = childrens;
        }
    }

    public static class CasesBean {
        /**
         * nodeId : 1419
         * nodeName : 遇见你在这个世界
         * image : http://images.9xi.com/d4341d67-4ed2-4316-98fa-f5549e3c696f_694_520.png
         * link : http://123.56.77.94:8080/htm/html/template/details_anli_v1.8.html?bizId=204
         * parentId : 1100
         * bizId : 204
         * nodeType : 96
         * bizType : 75
         * logoUrl : null
         * price : null
         * extraParams : {"likeNumber":10}
         * enName : null
         * childrens : null
         * likeNumber : 170
         * tabList : ["美丽"]
         * iconName :
         * remarks : 发的身份
         */

        private int nodeId;
        private String nodeName;
        private String image;
        private String link;
        private int parentId;
        private int bizId;
        private int nodeType;
        private int bizType;
        private Object logoUrl;
        private Object price;
        private ExtraParamsBean extraParams;
        private Object enName;
        private Object childrens;
        private int likeNumber;
        private String iconName;
        private String remarks;
        private List<String> tabList;

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public String getNodeName() {
            return nodeName;
        }

        public void setNodeName(String nodeName) {
            this.nodeName = nodeName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getNodeType() {
            return nodeType;
        }

        public void setNodeType(int nodeType) {
            this.nodeType = nodeType;
        }

        public int getBizType() {
            return bizType;
        }

        public void setBizType(int bizType) {
            this.bizType = bizType;
        }

        public Object getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(Object logoUrl) {
            this.logoUrl = logoUrl;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public ExtraParamsBean getExtraParams() {
            return extraParams;
        }

        public void setExtraParams(ExtraParamsBean extraParams) {
            this.extraParams = extraParams;
        }

        public Object getEnName() {
            return enName;
        }

        public void setEnName(Object enName) {
            this.enName = enName;
        }

        public Object getChildrens() {
            return childrens;
        }

        public void setChildrens(Object childrens) {
            this.childrens = childrens;
        }

        public int getLikeNumber() {
            return likeNumber;
        }

        public void setLikeNumber(int likeNumber) {
            this.likeNumber = likeNumber;
        }

        public String getIconName() {
            return iconName;
        }

        public void setIconName(String iconName) {
            this.iconName = iconName;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public List<String> getTabList() {
            return tabList;
        }

        public void setTabList(List<String> tabList) {
            this.tabList = tabList;
        }

        public static class ExtraParamsBean {
            /**
             * likeNumber : 10
             */

            private int likeNumber;

            public int getLikeNumber() {
                return likeNumber;
            }

            public void setLikeNumber(int likeNumber) {
                this.likeNumber = likeNumber;
            }
        }
    }

    public static class BoutiqueActivityBean {
        /**
         * nodeId : 1481
         * nodeName : 夏季报名活动开始啦活动的非法的地方方
         * image : http://images.9xi.com/fb17e9e4-ebdc-4b20-b405-e698101c3719_1035_534.png
         * link : http://123.56.77.94:8080/activity/act_chunji/actCont_2.html
         * parentId : 1107
         * bizId : 43
         * nodeType : 96
         * bizType : 314
         * logoUrl : http://images.9xi.com/bbe22cce-bae7-4ae3-928f-013878cf5f66_1035_534.png
         * price : null
         * extraParams : {"time":31334113098,"peopleNumLimit":1000,"signedNum":3}
         * enName : null
         * childrens : null
         * time : 1530066004000
         * peopleUpperlimit : null
         * signedNum : null
         */

        private int nodeId;
        private String nodeName;
        private String image;
        private String link;
        private int parentId;
        private int bizId;
        private int nodeType;
        private int bizType;
        private String logoUrl;
        private Object price;
        private ExtraParamsBeanX extraParams;
        private Object enName;
        private Object childrens;
        private long time;
        private Object peopleUpperlimit;
        private Object signedNum;

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public String getNodeName() {
            return nodeName;
        }

        public void setNodeName(String nodeName) {
            this.nodeName = nodeName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getNodeType() {
            return nodeType;
        }

        public void setNodeType(int nodeType) {
            this.nodeType = nodeType;
        }

        public int getBizType() {
            return bizType;
        }

        public void setBizType(int bizType) {
            this.bizType = bizType;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public ExtraParamsBeanX getExtraParams() {
            return extraParams;
        }

        public void setExtraParams(ExtraParamsBeanX extraParams) {
            this.extraParams = extraParams;
        }

        public Object getEnName() {
            return enName;
        }

        public void setEnName(Object enName) {
            this.enName = enName;
        }

        public Object getChildrens() {
            return childrens;
        }

        public void setChildrens(Object childrens) {
            this.childrens = childrens;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public Object getPeopleUpperlimit() {
            return peopleUpperlimit;
        }

        public void setPeopleUpperlimit(Object peopleUpperlimit) {
            this.peopleUpperlimit = peopleUpperlimit;
        }

        public Object getSignedNum() {
            return signedNum;
        }

        public void setSignedNum(Object signedNum) {
            this.signedNum = signedNum;
        }

        public static class ExtraParamsBeanX {
            /**
             * time : 31334113098
             * peopleNumLimit : 1000
             * signedNum : 3
             */

            private long time;
            private int peopleNumLimit;
            private int signedNum;

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getPeopleNumLimit() {
                return peopleNumLimit;
            }

            public void setPeopleNumLimit(int peopleNumLimit) {
                this.peopleNumLimit = peopleNumLimit;
            }

            public int getSignedNum() {
                return signedNum;
            }

            public void setSignedNum(int signedNum) {
                this.signedNum = signedNum;
            }
        }
    }

    public static class InformationBean {
        /**
         * nodeId : 1422
         * nodeName : 新人该知道的那些事
         * image : http://images.9xi.com/bcabba3d-a5f2-4d58-b285-6033953f00cb_640_359.jpeg
         * link : http://123.56.77.94:8080/htm/html/headlinedaily/im_details.html?bizId=205
         * parentId : 1105
         * bizId : 205
         * nodeType : 96
         * bizType : 74
         * logoUrl : null
         * price : null
         * extraParams : {"memberPhoto":"http://images.9xi.com/84e63b1b-9653-4263-a39a-68cad2832d50_224_223.png","collectStatus":false,"heartStatus":false,"memberType":5,"memberId":10032,"memberName":"哇雨"}
         * enName : null
         * childrens : null
         * browseNumber : 208
         * tabList : ["结婚登记小常识"]
         * replyNumber : 0
         * releaseName : 时尚新娘
         */

        private int nodeId;
        private String nodeName;
        private String image;
        private String link;
        private int parentId;
        private int bizId;
        private int nodeType;
        private int bizType;
        private Object logoUrl;
        private Object price;
        private ExtraParamsBeanXX extraParams;
        private Object enName;
        private Object childrens;
        private int browseNumber;
        private int replyNumber;
        private String releaseName;
        private List<String> tabList;

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public String getNodeName() {
            return nodeName;
        }

        public void setNodeName(String nodeName) {
            this.nodeName = nodeName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getNodeType() {
            return nodeType;
        }

        public void setNodeType(int nodeType) {
            this.nodeType = nodeType;
        }

        public int getBizType() {
            return bizType;
        }

        public void setBizType(int bizType) {
            this.bizType = bizType;
        }

        public Object getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(Object logoUrl) {
            this.logoUrl = logoUrl;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public ExtraParamsBeanXX getExtraParams() {
            return extraParams;
        }

        public void setExtraParams(ExtraParamsBeanXX extraParams) {
            this.extraParams = extraParams;
        }

        public Object getEnName() {
            return enName;
        }

        public void setEnName(Object enName) {
            this.enName = enName;
        }

        public Object getChildrens() {
            return childrens;
        }

        public void setChildrens(Object childrens) {
            this.childrens = childrens;
        }

        public int getBrowseNumber() {
            return browseNumber;
        }

        public void setBrowseNumber(int browseNumber) {
            this.browseNumber = browseNumber;
        }

        public int getReplyNumber() {
            return replyNumber;
        }

        public void setReplyNumber(int replyNumber) {
            this.replyNumber = replyNumber;
        }

        public String getReleaseName() {
            return releaseName;
        }

        public void setReleaseName(String releaseName) {
            this.releaseName = releaseName;
        }

        public List<String> getTabList() {
            return tabList;
        }

        public void setTabList(List<String> tabList) {
            this.tabList = tabList;
        }

        public static class ExtraParamsBeanXX {
            /**
             * memberPhoto : http://images.9xi.com/84e63b1b-9653-4263-a39a-68cad2832d50_224_223.png
             * collectStatus : false
             * heartStatus : false
             * memberType : 5
             * memberId : 10032
             * memberName : 哇雨
             */

            private String memberPhoto;
            private boolean collectStatus;
            private boolean heartStatus;
            private int memberType;
            private int memberId;
            private String memberName;

            public String getMemberPhoto() {
                return memberPhoto;
            }

            public void setMemberPhoto(String memberPhoto) {
                this.memberPhoto = memberPhoto;
            }

            public boolean isCollectStatus() {
                return collectStatus;
            }

            public void setCollectStatus(boolean collectStatus) {
                this.collectStatus = collectStatus;
            }

            public boolean isHeartStatus() {
                return heartStatus;
            }

            public void setHeartStatus(boolean heartStatus) {
                this.heartStatus = heartStatus;
            }

            public int getMemberType() {
                return memberType;
            }

            public void setMemberType(int memberType) {
                this.memberType = memberType;
            }

            public int getMemberId() {
                return memberId;
            }

            public void setMemberId(int memberId) {
                this.memberId = memberId;
            }

            public String getMemberName() {
                return memberName;
            }

            public void setMemberName(String memberName) {
                this.memberName = memberName;
            }
        }
    }

    public static class WeddingStepBean {
        /**
         * nodeId : 1123
         * nodeName : 婚礼小步骤
         * image :
         * link : http://html.9xi.com/html/xiaobuzhou/step_v1.8.html
         * parentId : 1103
         * bizId : 348
         * nodeType : 96
         * bizType : 71
         * logoUrl : null
         * price : null
         * extraParams : null
         * enName : null
         * childrens : null
         */

        private int nodeId;
        private String nodeName;
        private String image;
        private String link;
        private int parentId;
        private int bizId;
        private int nodeType;
        private int bizType;
        private Object logoUrl;
        private Object price;
        private Object extraParams;
        private Object enName;
        private Object childrens;

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public String getNodeName() {
            return nodeName;
        }

        public void setNodeName(String nodeName) {
            this.nodeName = nodeName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getNodeType() {
            return nodeType;
        }

        public void setNodeType(int nodeType) {
            this.nodeType = nodeType;
        }

        public int getBizType() {
            return bizType;
        }

        public void setBizType(int bizType) {
            this.bizType = bizType;
        }

        public Object getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(Object logoUrl) {
            this.logoUrl = logoUrl;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public Object getExtraParams() {
            return extraParams;
        }

        public void setExtraParams(Object extraParams) {
            this.extraParams = extraParams;
        }

        public Object getEnName() {
            return enName;
        }

        public void setEnName(Object enName) {
            this.enName = enName;
        }

        public Object getChildrens() {
            return childrens;
        }

        public void setChildrens(Object childrens) {
            this.childrens = childrens;
        }
    }
}
